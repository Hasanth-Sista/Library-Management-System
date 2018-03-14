package com.library.hasanth.business.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.library.hasanth.entities.BorrowerEntity;
import com.library.hasanth.resources.HibernateUtility;
import com.library.hasanth.resources.LibraryLogger;

public class BookCheckoutDAOImpl implements BookCheckoutDAO {

	private SessionFactory sessionfactory = HibernateUtility.createSessionFactory();

	@Override
	public String bookCheckoutMethod(String isbn, String title, String authors, String id) throws Exception {
		Session session = sessionfactory.openSession();
		session.beginTransaction();

		String message = "";
		try {

			Query query, query1 = null;

			String[] isbnNum = isbn.split(",");
			// System.out.println(isbnNum.length);

			query = session.createSQLQuery("SELECT * FROM book_loans where card_id= :id and date_in is null");
			query.setString("id", id);

			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();

			int leftOver = list.size() + isbnNum.length;

			if (list.size() == 3) {
				message += "You have already borrowed 3 books which is the maximum limit per borrower";
				return message;

			} else if (leftOver <= 3) {

				query1 = session.createQuery("select b from BorrowerEntity b where b = :id");
				query1.setString("id", id);

				@SuppressWarnings("unchecked")
				List<BorrowerEntity> list2 = query1.list();
				if (list2.size() == 0) {
					message += "You have given wrong card id. Please enter correct user id";
					return message;
				}

				Calendar localdatetime = Calendar.getInstance();
				localdatetime.add(Calendar.DATE, 13);
				Date due_date = localdatetime.getTime();

				for (int i = 0; i < isbnNum.length; i++) {

					Query query2 = session
							.createSQLQuery("insert into book_loans(card_id,isbn,date_out,due_date) values(?,?,?,?)");
					query2.setParameter(0, id);
					query2.setParameter(1, isbnNum[i]);
					query2.setParameter(2, new Date());
					query2.setParameter(3, due_date);

					query2.executeUpdate();

				}

				for (int i = 0; i < isbnNum.length; i++) {

					Query query4 = session.createSQLQuery("update availability set available='false' where isbn=?");
					query4.setParameter(0, isbnNum[i]);

					query4.executeUpdate();

				}
				session.getTransaction().commit();
				message += "Successfully borrowed books";
			} else {
				message += "You can check out a total of 3 books only. Number of books you can checkout are "
						+ (3 - list.size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			LibraryLogger.logError("BookCheckoutDAOImpl", "bookCheckoutMethod", e.toString());
		} finally {
			session.close();
		}
		return message;
	}

}

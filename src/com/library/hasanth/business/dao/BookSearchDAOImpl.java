package com.library.hasanth.business.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;

import com.library.hasanth.entities.AuthorEntity;
import com.library.hasanth.resources.HibernateUtility;
import com.library.hasanth.resources.LibraryLogger;
import com.mysql.jdbc.Statement;

public class BookSearchDAOImpl implements BookSearchAndAvailabilityDAO {
	private SessionFactory sessionfactory = HibernateUtility.createSessionFactory();

	@Override
	public List<Object[]> bookSearchForCheckOut(String inputText) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		try {

			Query query = null;

			String[] input = inputText.split(" ");
			System.out.println(input[0]);

			if (input.length == 1) {

				query = session.createSQLQuery("select distinct ba.isbn,b.title,group_concat(a.name separator ', ')"
						+ " as authors,av.available from Book_Authors ba inner join Book b inner join authors a"
						+ " join Availability av where ba.isbn in "
						+ " (select distinct b.isbn from Book b where (b.isbn like :name1) or "
						+ " (b.title like :name1) or (b.isbn in "
						+ " (select ba.isbn from Book_Authors ba where ba.author_id in (select a.author_id"
						+ " from Authors a where a.name like :name1)))) and av.isbn=ba.isbn"
						+ " and b.isbn=ba.isbn and ba.author_id=a.author_id group by ba.isbn;");

				query.setString("name1", "%" + input[0] + "%");

			} else if (input.length == 2) {

				query = session.createSQLQuery("select distinct ba.isbn,b.title,group_concat(a.name separator ', ')"
						+ " as authors,av.available from Book_Authors ba inner join Book b inner join authors a"
						+ " join Availability av where ba.isbn in "
						+ " (select distinct b.isbn from Book b where (b.isbn like :name1 or b.isbn like :name2) or "
						+ " (b.title like :name1 or b.title like :name2) or (b.isbn in "
						+ " (select ba.isbn from Book_Authors ba where ba.author_id in (select a.author_id"
						+ " from Authors a where a.name like :name1 or a.name like :name2)))) and av.isbn=ba.isbn"
						+ " and b.isbn=ba.isbn and ba.author_id=a.author_id group by ba.isbn;");

				query.setParameter("name1", "%" + input[0] + "%");
				query.setParameter("name2", "%" + input[1] + "%");

			} else if (input.length == 3) {

				query = session.createSQLQuery("select distinct ba.isbn,b.title,group_concat(a.name separator ', ')"
						+ " as authors,av.available from Book_Authors ba inner join Book b inner join authors a"
						+ " join Availability av where ba.isbn in "
						+ " (select distinct b.isbn from Book b where (b.isbn like :name1 or b.isbn like :name2 or b.isbn like :name3) or "
						+ " (b.title like :name1 or b.title like :name2 or b.title like :name3) or (b.isbn in "
						+ " (select ba.isbn from Book_Authors ba where ba.author_id in (select a.author_id"
						+ " from Authors a where a.name like :name1 or a.name like :name2 or a.name like :name3)))) and av.isbn=ba.isbn"
						+ " and b.isbn=ba.isbn and ba.author_id=a.author_id group by ba.isbn;");

				query.setParameter("name1", "%" + input[0] + "%");
				query.setParameter("name2", "%" + input[1] + "%");
				query.setParameter("name3", "%" + input[2] + "%");
			}

			@SuppressWarnings("unchecked")
			List<Object[]> list = (List<Object[]>) query.list();
			// System.out.println(list.size());
			return list;

		} catch (Exception e) {
			LibraryLogger.logError("BookSearchDAOImpl", "bookSearchForCheckOut", e.toString());
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Object[]> bookSearchForCheckIn(String inputText) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		try {

			Query query = null;

			String[] input = inputText.split(" ");


			if (input.length == 1) {
				query = session
						.createSQLQuery("SELECT b.loan_id,b.isbn,b.card_id,b.date_out,b.due_date FROM book_loans b "
								+ "inner join borrower bo on b.card_id=bo.card_id where b.date_in is null and "
								+ "(b.isbn like :name1 or b.card_id like :name1 or bo.bname like :name1)");

				query.setString("name1", "%" + input[0] + "%");

			} else if (input.length == 2) {

				query = session
						.createSQLQuery("SELECT b.loan_id,b.isbn,b.card_id,b.date_out,b.due_date FROM book_loans b "
								+ "inner join borrower bo on b.card_id=bo.card_id where b.date_in is null and "
								+ "((b.isbn like :name1 or b.isbn like :name2) "
								+ "or (b.card_id like :name1 or b.card_id like :name2) "
								+ "or (bo.bname like :name1 or bo.bname like :name2))");

				query.setParameter("name1", "%" + input[0] + "%");
				query.setParameter("name2", "%" + input[1] + "%");

			} else if (input.length == 3) {

				query = session
						.createSQLQuery("SELECT b.loan_id,b.isbn,b.card_id,b.date_out,b.due_date FROM book_loans b "
								+ "inner join borrower bo on b.card_id=bo.card_id where b.date_in is null and "
								+ "((b.isbn like :name1 or b.isbn like :name2 or b.isbn like :name3) "
								+ "or (b.card_id like :name1 or b.card_id like :name2 or b.card_id like :name3) "
								+ "or (bo.bname like :name1 or bo.bname like :name2 or bo.bname like :name3))");

				query.setParameter("name1", "%" + input[0] + "%");
				query.setParameter("name2", "%" + input[1] + "%");
				query.setParameter("name3", "%" + input[2] + "%");
			}

			@SuppressWarnings("unchecked")
			List<Object[]> list = (List<Object[]>) query.list();
			
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			LibraryLogger.logError("BookSearchDAOImpl", "bookSearchForCheckIn", e.toString());
		} finally {
			session.close();
		}

		return null;
	}

}

package com.library.hasanth.business.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.library.hasanth.beans.Fines;
import com.library.hasanth.resources.HibernateUtility;
import com.library.hasanth.resources.LibraryLogger;

public class FineDetailsDAOImpl implements FineDetailsDAO {
	private SessionFactory sessionfactory = HibernateUtility.createSessionFactory();

	public List<Object[]> getFineDetails() {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		try {

			Query query, query1, query2, query3, query4 = null;

			query = session.createSQLQuery(
					"select bl.loan_id,bl.card_id,bl.due_date from book_loans bl where bl.date_in is null");

			@SuppressWarnings("unchecked")
			List<Object[]> list = query.list();

			for (int i = 0; i < list.size(); i++) {
				Object[] obj = list.get(i);
				String id = obj[0].toString();
				String due = obj[2].toString();

				Date due_d = new SimpleDateFormat("yyyy-MM-dd").parse(due.split(" ")[0]);
				Date in = new Date();

				long difference = (in.getTime() - due_d.getTime()) / 86400000;
				double amt = 0;
				if (difference > 0) {
					amt = (difference) * 0.25;
				}

				query2 = session.createSQLQuery("select * from fines f where f.loan_id=?");
				query2.setParameter(0, id);

				@SuppressWarnings({ "unchecked" })
				List<Object[]> list2 = query2.list();

				if (list2.size() == 0 && amt != 0) {
					query3 = session.createSQLQuery("insert into fines (loan_id,fine_amt,paid) values(?,?,?)");
					query3.setParameter(0, id);
					query3.setParameter(1, amt);
					query3.setParameter(2, false);

					query3.executeUpdate();
				} else {

					query4 = session.createSQLQuery("update fines set fine_amt=? where loan_id=?");
					query4.setParameter(0, amt);
					query4.setParameter(1, id);
				}

			}

			query1 = session.createSQLQuery("select sum(f.fine_amt),bl.card_id,f.paid from fines f, book_loans bl "
					+ "where bl.loan_id=f.loan_id group by bl.card_id,f.paid;");

			@SuppressWarnings("unchecked")
			List<Object[]> list1 = query1.list();

			return list1;

		} catch (Exception e) {
			LibraryLogger.logError("FineDetailsDAOImpl", "getFineDetails", e.toString());
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public String getFineUpdate(String card_id, String fine_amt, String f_paid) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getFinePaid(String card_id, String fine_amt, String f_paid) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		String message = "";
		try {

			Query query, query1 = null;

			String[] card_ids = card_id.split(",");
			//System.out.println(card_ids[0]);

			for (int i = 0; i < card_ids.length; i++) {
				query = session.createSQLQuery("select * from book_loans where card_id=?");
				query.setParameter(0, card_ids[i]);

				List<Object[]> list = query.list();

				for (int j = 0; j < list.size(); j++) {
					Object[] obj = list.get(j);
					//System.out.println(obj[4]+" "+obj[5]);

					String due_date = obj[4].toString();
					Date d = new SimpleDateFormat("yyyy-MM-dd").parse(due_date);
					
				//	System.out.println(d.compareTo(new Date()));

					if (d.compareTo(new Date()) < 0 || obj[5] == null) {

						message += "Books have not been returned so cannot update the fine";
						return message;
					}

				}

				for (int j = 0; j < list.size(); j++) {
					Object[] obj = list.get(j);

					query1 = session.createSQLQuery("update fines set paid=true where loan_id=?");
					query1.setParameter(0, obj[0]);

					query1.executeUpdate();

				}
			}
			session.getTransaction().commit();
			message += "Successfully updated fines";
			return message;

		} catch (Exception e) {
			LibraryLogger.logError("FineDetailsDAOImpl", "getFinePaid", e.toString());
		} finally {
			session.close();
		}
		return null;
	}

	public List<Fines> getDetails(String card_id, String fine_amt, String paid) {

		List<Fines> fines = new ArrayList<>();

		String[] card_Nos = card_id.split(",");

		String[] fams = fine_amt.split(",");

		String[] paids = paid.split(",");

		for (int i = 0; i < card_Nos.length; i++) {

			Fines fine = new Fines();
			fine.setFine_amt(Double.valueOf(fams[i]));
			fine.setCard_id(card_Nos[i]);
			fine.setPaid(Boolean.valueOf(paids[i]));

			fines.add(fine);

		}

		return fines;
	}

	public String updateFineRecords(String card_id, String fine_amt, String paid) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		String message = "";
		try {

			message += "Successfully updated fine records";
			return message;

		} catch (

		Exception e) {
			LibraryLogger.logError("FineDetailsDAOImpl", "updateFineRecords", e.toString());
		} finally {
			session.close();
		}
		return null;
	}
}

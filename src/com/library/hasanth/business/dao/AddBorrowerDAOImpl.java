package com.library.hasanth.business.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.library.hasanth.resources.HibernateUtility;
import com.library.hasanth.resources.LibraryLogger;

public class AddBorrowerDAOImpl implements AddBorrowerDAO {
	private SessionFactory sessionfactory = HibernateUtility.createSessionFactory();

	@Override
	public String addBorrowerMethod(String ssn, String bname, String address, String phone) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.beginTransaction();

		String message = "";
		try {

			Query query, query1,query2 = null;
			
			query = session.createSQLQuery("select b.card_id from borrower b where b.ssn = :ssn");
			query.setString("ssn", ssn);
			
			@SuppressWarnings("unchecked")
			List<Object[]> list=query.list();
			
			if(list.size()==1){
				message+="User already has a library card";
				return message;
			}
			query1 = session.createSQLQuery("insert into borrower(ssn,bname,address,phone) values(?,?,?,?)");
			query1.setParameter(0, ssn);
			query1.setParameter(1, bname);
			query1.setParameter(2, address);
			query1.setParameter(3, phone);
			
			query1.executeUpdate();
			session.getTransaction().commit();
			
			query2 = session.createSQLQuery("select b.card_id from borrower b where b.ssn = :ssn");
			query2.setString("ssn", ssn);
			
			@SuppressWarnings("unchecked")
			List<Object[]> list2=query2.list();
			
		
			message +="User successfully added and his card number is "+list2.get(0);
			
		} catch (Exception e){
			LibraryLogger.logError("AddBorrowerDAOImpl", "addBorrowerMethod", e.toString());
		} finally {
			session.close();
		}
		return message;
	}

}

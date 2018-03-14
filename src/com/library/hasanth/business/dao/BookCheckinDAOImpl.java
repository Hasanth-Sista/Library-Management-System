package com.library.hasanth.business.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.library.hasanth.resources.HibernateUtility;
import com.library.hasanth.resources.LibraryLogger;

public class BookCheckinDAOImpl implements BookCheckinDAO {

	private SessionFactory sessionfactory = HibernateUtility.createSessionFactory();

	@Override
	public String bookCheckinMethod(String loan_id, String isbn, String card_id, String due_date, String date_out)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		session.beginTransaction();

		String message = "";
		try {

			Query query,query1,query2,query3 = null;

			String[] isbns = isbn.split(",");
			// System.out.println(isbnNum.length);

			for (int i = 0; i < isbns.length; i++) {

				query = session.createSQLQuery("update book_loans set date_in = ? where isbn= ?");
				query.setParameter(0, new Date());
				query.setParameter(1, isbns[i]);

				query.executeUpdate();
				
				query1=session.createSQLQuery("update availability set available='true' where isbn=?");
				query1.setParameter(0, isbns[i]);
				
				query1.executeUpdate();
				
				
				query2=session.createSQLQuery("select loan_id,date_out,due_date,date_in from book_loans where "
						+ "card_id = :card_id and date_in is not null");
				query2.setString("card_id", card_id);
				
				@SuppressWarnings("unchecked")
				List<Object[]> list=query2.list();
				
				
				for(int j=0;j<list.size();j++){
					
					Object[] obj=list.get(j);
					String id=obj[0].toString();
					String due=obj[2].toString();
					String in=obj[3].toString();
//					
//					Calendar due_cal=Calendar.getInstance();
//					Calendar in_cal=Calendar.getInstance();
					
					Date in_d=new SimpleDateFormat("yyyy-MM-dd").parse(in.split(" ")[0]);
					Date due_d=new SimpleDateFormat("yyyy-MM-dd").parse(due.split(" ")[0]);
					//System.out.println(in_d+"  "+due_d);
					
					long difference =  (in_d.getTime()-due_d.getTime())/86400000;
			        //System.out.println(difference);
					
			        if(difference>0){
			        	
			        	double amt=(difference)*0.25;
			        	
			        
			        	query3=session.createSQLQuery("insert into fines (loan_id,fine_amt,paid) values(?,?,?)");
			        	query3.setParameter(0, id);
			        	query3.setParameter(1, amt);
			        	query3.setParameter(2, false);
			        	
			        	query3.executeUpdate();
			        	
			        	
					}
					
				}
				
				
				session.getTransaction().commit();

			}
			message+="Successfully checked in";
		} catch (Exception e) {
			e.printStackTrace();
			LibraryLogger.logError("BookCheckinDAOImpl", "bookCheckinMethod", e.toString());
		} finally {
			session.close();
		}
		return message;

	}

}

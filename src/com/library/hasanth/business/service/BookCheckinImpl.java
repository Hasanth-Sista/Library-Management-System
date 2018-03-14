/**
 * 
 */
package com.library.hasanth.business.service;

import com.library.hasanth.business.dao.BookCheckinDAO;
import com.library.hasanth.business.dao.BookCheckoutDAO;
import com.library.hasanth.resources.Factory;
import com.library.hasanth.resources.LibraryLogger;

/**
 * @author sista
 *
 */
public class BookCheckinImpl implements BookCheckin {

	/* (non-Javadoc)
	 * @see com.library.hasanth.business.service.BookCheckin#bookCheckinMethod(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String bookCheckinMethod(String loan_id, String isbn, String card_id, String due_date, String date_out)
			throws Exception {
		// TODO Auto-generated method stub
		BookCheckinDAO dao = Factory.createBookCheckinDAOImpl();
		try {
			String list=dao.bookCheckinMethod(loan_id, isbn, card_id, due_date, date_out);

			return list;
		} catch (Exception e) {
			LibraryLogger.logError("BookCheckinImpl", "bookCheckinMethod", e.toString());
		}
		return null;

	}

}

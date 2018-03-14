package com.library.hasanth.business.service;

import com.library.hasanth.business.dao.BookCheckoutDAO;
import com.library.hasanth.resources.Factory;
import com.library.hasanth.resources.LibraryLogger;

public class BookCheckoutImpl implements BookCheckout {

	@Override
	public String bookCheckoutMethod(String isbn, String title, String authors, String id) throws Exception {
		// TODO Auto-generated method stub
		BookCheckoutDAO dao = Factory.createBookCheckoutDAOImpl();
		try {
			String list=dao.bookCheckoutMethod(isbn, title, authors, id);

			return list;
		} catch (Exception e) {
			LibraryLogger.logError("BookCheckoutImpl", "bookCheckoutMethod", e.toString());
		}
		return null;

	}

}

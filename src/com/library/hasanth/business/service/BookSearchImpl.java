package com.library.hasanth.business.service;


import java.util.List;

import com.library.hasanth.business.dao.BookSearchAndAvailabilityDAO;
import com.library.hasanth.resources.Factory;
import com.library.hasanth.resources.LibraryLogger;

public class BookSearchImpl implements BookSearchAndAvailability {

	@Override
	public List<Object[]> bookSearchForCheckOut(String inputText) throws Exception {
		// TODO Auto-generated method stub
		BookSearchAndAvailabilityDAO dao = Factory.createBookSearchDAOImpl();
		try {
			List<Object[]> list=dao.bookSearchForCheckOut(inputText);

			return list;
		} catch (Exception e) {
			LibraryLogger.logError("BookSearchImpl", "bookSearchForCheckOut", e.toString());
		}
		return null;
	}

	@Override
	public List<Object[]> bookSearchForCheckIn(String inputText) throws Exception {
		// TODO Auto-generated method stub
		BookSearchAndAvailabilityDAO dao = Factory.createBookSearchDAOImpl();
		try {
			List<Object[]> list=dao.bookSearchForCheckIn(inputText);

			return list;
		} catch (Exception e) {
			LibraryLogger.logError("BookSearchImpl", "bookSearchForCheckIn", e.toString());
		}
		return null;

	}

}

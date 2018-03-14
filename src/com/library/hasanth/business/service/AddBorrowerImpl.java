package com.library.hasanth.business.service;

import com.library.hasanth.business.dao.AddBorrowerDAO;
import com.library.hasanth.business.dao.BookCheckoutDAO;
import com.library.hasanth.resources.Factory;
import com.library.hasanth.resources.LibraryLogger;

public class AddBorrowerImpl implements AddBorrower {

	@Override
	public String addBorrowerMethod(String ssn, String bname, String address, String phone) {
		// TODO Auto-generated method stub
		AddBorrowerDAO dao=Factory.createAddBorrowerDAOImpl();
		try {
			String message=dao.addBorrowerMethod(ssn, bname, address, phone);

			return message;
		} catch (Exception e) {
			LibraryLogger.logError("AddBorrowerImpl", "addBorrowerMethod", e.toString());
		}

		return null;
	}

}

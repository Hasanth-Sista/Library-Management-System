package com.library.hasanth.resources;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.library.hasanth.business.dao.AddBorrowerDAO;
import com.library.hasanth.business.dao.AddBorrowerDAOImpl;
import com.library.hasanth.business.dao.BookCheckinDAO;
import com.library.hasanth.business.dao.BookCheckinDAOImpl;
import com.library.hasanth.business.dao.BookCheckoutDAO;
import com.library.hasanth.business.dao.BookCheckoutDAOImpl;
import com.library.hasanth.business.dao.BookSearchAndAvailabilityDAO;
import com.library.hasanth.business.dao.BookSearchDAOImpl;
import com.library.hasanth.business.dao.FineDetailsDAO;
import com.library.hasanth.business.dao.FineDetailsDAOImpl;
import com.library.hasanth.business.service.AddBorrower;
import com.library.hasanth.business.service.AddBorrowerImpl;
import com.library.hasanth.business.service.BookCheckin;
import com.library.hasanth.business.service.BookCheckinImpl;
import com.library.hasanth.business.service.BookCheckout;
import com.library.hasanth.business.service.BookCheckoutImpl;
import com.library.hasanth.business.service.BookSearchAndAvailability;
import com.library.hasanth.business.service.BookSearchImpl;
import com.library.hasanth.business.service.FineDetails;
import com.library.hasanth.business.service.FineDetailsImpl;


public class Factory {

	public static BookSearchAndAvailability createBookSearchImpl(){
		return new BookSearchImpl();
	}
	
	public static BookSearchAndAvailabilityDAO createBookSearchDAOImpl(){
		return new BookSearchDAOImpl();
	}
	public static BookCheckout createBookCheckoutImpl(){
		return new BookCheckoutImpl();
	}
	public static BookCheckoutDAO createBookCheckoutDAOImpl(){
		return new BookCheckoutDAOImpl();
	}
	
	public static BookCheckin createBookCheckinImpl(){
		return new BookCheckinImpl();
	}
	
	public static BookCheckinDAO createBookCheckinDAOImpl(){
		return new BookCheckinDAOImpl();
	}
	
	public static AddBorrower createAddBorrowerImpl(){
		return new AddBorrowerImpl();
	}
	
	public static AddBorrowerDAO createAddBorrowerDAOImpl(){
		return new AddBorrowerDAOImpl();
	}
	
	public static FineDetails createFineDetailsImpl(){
		return new FineDetailsImpl();
	}
	
	public static FineDetailsDAO createFineDetailsDAOImpl(){
		return new FineDetailsDAOImpl();
	}
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}

}

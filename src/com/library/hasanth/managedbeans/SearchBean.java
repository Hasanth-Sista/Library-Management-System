package com.library.hasanth.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.library.hasanth.beans.BookBeanSearch;
import com.library.hasanth.beans.BookCheckIn;
import com.library.hasanth.business.service.BookSearchAndAvailability;
import com.library.hasanth.resources.Factory;
import com.library.hasanth.resources.LibraryLogger;	

@ManagedBean
@RequestScoped
public class SearchBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String search;
	

	private List<BookBeanSearch> bookBeanSearch=new ArrayList<>();
	
	public String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<BookBeanSearch> getBookBeanSearch() {
		return bookBeanSearch;
	}
	
	public List<BookCheckIn> bookCheckIns=new ArrayList<>();
	
	
	public List<BookCheckIn> getBookCheckIns() {
		return bookCheckIns;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	public String bookSearchCheckOut(){
		BookSearchAndAvailability availability=Factory.createBookSearchImpl();
		try {
			List<Object[]> list=availability.bookSearchForCheckOut(this.search.toString());
			
			
			for(int i=0;i<list.size();i++){
				BookBeanSearch beanSearch=new BookBeanSearch();
				Object[] display=list.get(i);
				
		
				beanSearch.setIsbn(display[0].toString());
				beanSearch.setTitle(display[1].toString());
				beanSearch.setAvailability(display[3].toString());
				beanSearch.setAuthors(display[2].toString());
				
				bookBeanSearch.add(beanSearch);
				}

		} catch (Exception e) {
			LibraryLogger.logError("SearchBean", "bookSearchCheckOut", e.toString());
			
		}
		return "DisplaySearchResult.jsp";
	}
	
	
	public String bookSearchCheckIn(){
		BookSearchAndAvailability availability=Factory.createBookSearchImpl();
		try {
			List<Object[]> list=availability.bookSearchForCheckIn(this.search.toString());
			
			if(list.size()==0){
				message="No books to check in for the user";
				return "FailurePage.jsp";
				}
			for(int i=0;i<list.size();i++){
				BookCheckIn bookCheckIn=new BookCheckIn();
				Object[] display=list.get(i);
				
		
				bookCheckIn.setLoan_id(display[0].toString());
				bookCheckIn.setIsbn(display[1].toString());
				bookCheckIn.setCard_id(display[2].toString());
				bookCheckIn.setDate_out(display[3].toString());
				bookCheckIn.setDue_date(display[4].toString());
				
				
				bookCheckIns.add(bookCheckIn);
				}
			
			
		} catch (Exception e) {

			LibraryLogger.logError("SearchBean", "bookSearchCheckIn", e.toString());
		}
		return "DisplayCheckIn.jsp";
	}
	
}

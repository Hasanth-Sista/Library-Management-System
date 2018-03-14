package com.library.hasanth.business.dao;

public interface BookCheckoutDAO {
	
	public String bookCheckoutMethod(String isbn, String title, String authors, String id) throws Exception; 
	
}

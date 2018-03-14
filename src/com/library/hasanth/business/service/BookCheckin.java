package com.library.hasanth.business.service;

public interface BookCheckin {
	
	public String bookCheckinMethod(String loan_id, String isbn, String card_id, String due_date,String date_out) throws Exception; 
	
}

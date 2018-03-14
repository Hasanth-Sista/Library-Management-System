package com.library.hasanth.business.service;

import java.util.List;

import com.library.hasanth.beans.Fines;


public interface FineDetails {

	public List<Object[]> getFineDetails();
	
	public String getFineUpdate(String card_id,String fine_amt,String paid);
	
	public String getFinePaid(String card_id,String fine_amt,String f_paid);
	
	public List<Fines> getDetails(String card_id,String fine_amt,String paid);
	
	
	public String updateFineRecords(String card_id,String fine_amt,String paid);
}

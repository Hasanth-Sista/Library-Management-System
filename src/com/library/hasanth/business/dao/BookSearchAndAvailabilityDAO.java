package com.library.hasanth.business.dao;

import java.util.List;

public interface BookSearchAndAvailabilityDAO {


	public List<Object[]> bookSearchForCheckIn(String inputText) throws Exception;
	
	public List<Object[]> bookSearchForCheckOut(String inputText) throws Exception;
	
}

package com.library.hasanth.business.service;

import java.util.List;

public interface BookSearchAndAvailability {

	public List<Object[]> bookSearchForCheckIn(String inputText) throws Exception;

	public List<Object[]> bookSearchForCheckOut(String inputText) throws Exception;

}

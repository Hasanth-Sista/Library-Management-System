package com.library.hasanth.business.service;

import java.util.List;

import com.library.hasanth.beans.Fines;
import com.library.hasanth.business.dao.FineDetailsDAO;
import com.library.hasanth.resources.Factory;
import com.library.hasanth.resources.LibraryLogger;

public class FineDetailsImpl implements FineDetails {

	@Override
	public List<Object[]> getFineDetails() {
		// TODO Auto-generated method stub
		FineDetailsDAO dao = Factory.createFineDetailsDAOImpl();
		try {
			List<Object[]> list=dao.getFineDetails();

			return list;
		} catch (Exception e) {
			LibraryLogger.logError("FineDetailsImpl", "getFineDetails", e.toString());
		}
		return null;
	}

	@Override
	public String getFineUpdate(String card_id,String fine_amt,String paid) {
		// TODO Auto-generated method stub
		FineDetailsDAO dao = Factory.createFineDetailsDAOImpl();
		try {
			String list=dao.getFineUpdate(card_id,fine_amt,paid);

			return list;
		} catch (Exception e) {
			LibraryLogger.logError("FineDetailsImpl", "getFineUpdate", e.toString());
		}
		return null;

	}

	@Override
	public String getFinePaid(String card_id,String fine_amt,String f_paid) {
		// TODO Auto-generated method stub
		FineDetailsDAO dao = Factory.createFineDetailsDAOImpl();
		try {
			String list=dao.getFinePaid(card_id,fine_amt,f_paid);

			return list;
		} catch (Exception e) {
			LibraryLogger.logError("FineDetailsImpl", "getFinePaid", e.toString());
		}
		return null;
	}

	public List<Fines> getDetails(String card_id,String fine_amt,String paid){
		FineDetailsDAO dao = Factory.createFineDetailsDAOImpl();
		try {
			List<Fines> list=dao.getDetails(card_id,fine_amt,paid);

			return list;
		} catch (Exception e) {
			LibraryLogger.logError("FineDetailsImpl", "getDetails", e.toString());
		}
		return null;

	}

	public String updateFineRecords(String card_id,String fine_amt,String paid){
		FineDetailsDAO dao = Factory.createFineDetailsDAOImpl();
		try {
			String list=dao.updateFineRecords(card_id, fine_amt, paid);

			return list;
		} catch (Exception e) {
			LibraryLogger.logError("FineDetailsImpl", "updateFineRecords", e.toString());
		}
		return null;

	}
}

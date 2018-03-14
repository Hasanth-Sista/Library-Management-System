package com.library.hasanth.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.library.hasanth.beans.Fines;
import com.library.hasanth.business.service.AddBorrower;
import com.library.hasanth.business.service.FineDetails;
import com.library.hasanth.resources.Factory;
import com.library.hasanth.resources.LibraryLogger;

@ManagedBean
@RequestScoped
public class FinesBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String card_no;
	private Double fine_amt;	
	private Boolean paid;
	
	private List<Fines> fines=new ArrayList<>();
	
	
	public List<Fines> getFines() {
		return fines;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	
	public Double getFine_amt() {
		return fine_amt;
	}
	public void setFine_amt(Double fine_amt) {
		this.fine_amt = fine_amt;
	}
	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	
	public String getFineOfUser(){
		FineDetails fineDetails=Factory.createFineDetailsImpl();
		try {
			
			List<Object[]> list=fineDetails.getFineDetails();
			
			if(list.size()==0){
				return "NoFinePage.jsp";
			}
			
			
			for(int i=0;i<list.size();i++){
				Object[] obj=list.get(i);
 				Double amt=Double.valueOf(obj[0].toString());
				String card_id=obj[1].toString();
				Boolean paid=Boolean.valueOf(obj[2].toString());
				
				
				Fines fine=new Fines();
				fine.setFine_amt(amt);
				fine.setCard_id(card_id);
				fine.setPaid(paid);
				
				fines.add(fine);
				
			}
			
			
		} catch (Exception e) {

			LibraryLogger.logError("FinesBean", "getFineOfUser", e.toString());
		}
		return "FineDetails.jsp";
	}
	
}

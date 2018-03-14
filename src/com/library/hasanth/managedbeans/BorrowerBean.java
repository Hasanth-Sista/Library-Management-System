package com.library.hasanth.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.library.hasanth.business.service.AddBorrower;
import com.library.hasanth.resources.Factory;
import com.library.hasanth.resources.LibraryLogger;

@ManagedBean
@RequestScoped
public class BorrowerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ssn;
	private String bname;
	private String address;

	private String city;

	private String state;
	
	private String phone;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String addUser(){
		AddBorrower borrower=Factory.createAddBorrowerImpl();
		try {
			
			address=address+","+city+","+state;
			
			message=borrower.addBorrowerMethod(ssn, bname, address, phone);
			
		} catch (Exception e) {

			LibraryLogger.logError("BorrowerBean", "addUser", e.toString());
		}
		return "Success.jsp";

	}
	
}

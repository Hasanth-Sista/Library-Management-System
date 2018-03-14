package com.library.hasanth.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.library.hasanth.beans.BookLoans;
import com.library.hasanth.beans.Fines;

@Entity
@Table(name="borrower")
public class BorrowerEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String card_id;
	
	private String ssn;
	private String bname;
	private String address;
	private String phone;
	
	
	@Transient
	@OneToMany(cascade=CascadeType.ALL)
	private List<BookLoans> bookLoans=new ArrayList<>();
	

	@Transient
	@OneToMany(cascade=CascadeType.ALL)
	private List<Fines> fines=new ArrayList<>();
	
	
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
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

}

package com.library.hasanth.beans;

public class Fines {

	private String loan_id;
	private Double fine_amt;
	private Boolean paid;
	
	private String card_id;
	
	
	
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
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
	
	
		
}

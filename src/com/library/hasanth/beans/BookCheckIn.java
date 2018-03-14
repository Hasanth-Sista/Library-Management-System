package com.library.hasanth.beans;

import java.util.Date;

public class BookCheckIn {
	
	
	private String isbn;
	private String loan_id;
	private String card_id;
	private String due_date;
	private String date_out;
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getDate_out() {
		return date_out;
	}
	public void setDate_out(String date_out) {
		this.date_out = date_out;
	}
		

}

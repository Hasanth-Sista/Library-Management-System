package com.library.hasanth.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.library.hasanth.beans.BookLoans;

@Entity
@Table(name = "fines")
public class FinesEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@OneToOne(targetEntity=BookLoansEntity.class)
	@JoinColumn(name="loan_id")
	private BookLoans bookLoan;

	private Double fine_amt;
		
	private Boolean paid;

	

	public BookLoans getBookLoan() {
		return bookLoan;
	}

	public void setBookLoan(BookLoans bookLoan) {
		this.bookLoan = bookLoan;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}

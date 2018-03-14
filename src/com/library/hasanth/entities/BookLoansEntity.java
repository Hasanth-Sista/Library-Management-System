package com.library.hasanth.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.library.hasanth.beans.Book;
import com.library.hasanth.beans.Borrower;

@Entity
@Table(name="book_loans")
public class BookLoansEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer loan_id;
	
	@OneToOne(targetEntity=BookEntity.class)
	@JoinColumn(name="isbn")
	private Book bookbean;
	
	@OneToOne(targetEntity=BorrowerEntity.class)
	@JoinColumn(name="card_id")
	private Borrower borrowerbean;
	
	private Date date_out;
	private Date due_date;
	private Date date_in;
	
	public Integer getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(Integer loan_id) {
		this.loan_id = loan_id;
	}
	
	
	
	
	
	public Book getBookbean() {
		return bookbean;
	}
	public void setBookbean(Book bookbean) {
		this.bookbean = bookbean;
	}
	public Borrower getBorrowerbean() {
		return borrowerbean;
	}
	public void setBorrowerbean(Borrower borrowerbean) {
		this.borrowerbean = borrowerbean;
	}
	public Date getDate_out() {
		return date_out;
	}
	public void setDate_out(Date date_out) {
		this.date_out = date_out;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getDate_in() {
		return date_in;
	}
	public void setDate_in(Date date_in) {
		this.date_in = date_in;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

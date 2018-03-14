package com.library.hasanth.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.library.hasanth.beans.Authors;
import com.library.hasanth.beans.Availability;
import com.library.hasanth.beans.Book;


@Entity
@Table(name = "book_authors")
public class BookAuthorsEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne(targetEntity=AuthorEntity.class)
	@JoinColumn(name="author_id")
	private Authors author;
	

	@Id
	@OneToOne(targetEntity=BookEntity.class)
	@JoinColumn(name="isbn")
	private Book book;




	public Authors getAuthor() {
		return author;
	}



	public void setAuthor(Authors author) {
		this.author = author;
	}
  
	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}

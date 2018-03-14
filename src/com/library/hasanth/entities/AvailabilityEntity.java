package com.library.hasanth.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="availability")
public class AvailabilityEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@OneToOne(targetEntity=BookEntity.class)
	@JoinColumn(name="isbn")
	private String isbn;
	
	private String available;
	
	
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

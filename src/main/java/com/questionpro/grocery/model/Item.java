package com.questionpro.grocery.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item implements Serializable {
	
	// Base on business requirement we can add many other field also.
	//To  make it simple I just add few of them.
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String name;
	
	private Double price;
	
	private Long stock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}	

}

package com.questionpro.grocery.dto;

import java.io.Serializable;
import java.util.List;

import com.questionpro.grocery.model.Item;

public class ItemBookResponseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public List<Item> itemBooked;
	
	public List<Item> getItemBooked() {
		return itemBooked;
	}

	public void setItemBooked(List<Item> itemBooked) {
		this.itemBooked = itemBooked;
	}

	public List<Long> itemNotBooked;

	public List<Long> getItemNotBooked() {
		return itemNotBooked;
	}

	public void setItemNotBooked(List<Long> itemNotBooked) {
		this.itemNotBooked = itemNotBooked;
	}
	
	

}

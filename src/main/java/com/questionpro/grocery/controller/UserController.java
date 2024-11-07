package com.questionpro.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.grocery.dto.ItemBookResponseDto;
import com.questionpro.grocery.model.Item;
import com.questionpro.grocery.service.ItemService;

@RestController("/user")
public class UserController {
	
	@Autowired
	ItemService itemService;
	
	
	/*
	 * This service will find all existing item
	 * eaxmple : 127.0.0.1:8080/user/item/view
	 */
	
	@GetMapping("/item/view")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	/*
	 * This service will send a list of item id to book and will get what are item booked
	 * and what item are not able to book for various reason like stock is not available.
	 */
	@PostMapping("/item/booking")
	public ItemBookResponseDto addItem(@RequestBody List<Long> itemIds) {
		return itemService.bookItems(itemIds);
		
	}

}

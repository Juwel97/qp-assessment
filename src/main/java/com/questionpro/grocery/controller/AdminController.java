package com.questionpro.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.grocery.dto.ItemInventoryRequestDto;
import com.questionpro.grocery.model.Item;
import com.questionpro.grocery.service.ItemService;

@RestController("/admin")
public class AdminController {
	
	@Autowired
	ItemService itemService;
	
	
	/*
	 * This service will take an Item info as request in JSON format and
	 * will update the item in database.
	*/
	@PostMapping("/item/add")
	public String addItem(@RequestBody Item item) {
		return itemService.addItem(item);
		
	}
	
	/*
	 * This service will find an existing item by providing the item id as request
	 * eaxmple : 127.0.0.1:8080/admin/item/view/1
	 */
	@GetMapping("/item/view/{id}")
	public Item getExitingItemsById(@PathVariable("id") Long id) {
		return itemService.getExitingItemsById(id);
	}
	
	/*
	 * This service will delete an existing item by providing the item id as request
	 * eaxmple : 127.0.0.1:8080/admin/remove/1
	 */
	
	@DeleteMapping("/item/remove/{id}")
	public String removeItemsById(@PathVariable("id") Long id) {
		return itemService.removeItemsById(id);
	}
	
	/*
	 * This service will update an existing item by providing the item as request body
	 * eaxmple : 127.0.0.1:8080/admin/update
	 */
	@PostMapping("/item/update")
	public String updateItem(@RequestBody Item item) {
		return itemService.updateItem(item);
		
	}
	

	/*
	 * This service will update stock of an existing item by providing the item id and stock 
	 * as request body eaxmple : 127.0.0.1:8080/admin/item/item
	 */
	
	@PostMapping("/item/item")
	public String updateItem(@RequestBody ItemInventoryRequestDto itemInventoryRequestDto) {
		return itemService.updateItemInventory(itemInventoryRequestDto);
		
	}

}

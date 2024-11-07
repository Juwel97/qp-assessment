package com.questionpro.grocery.service;

import java.util.List;

import com.questionpro.grocery.dto.ItemBookResponseDto;
import com.questionpro.grocery.dto.ItemInventoryRequestDto;
import com.questionpro.grocery.model.Item;

public interface ItemService {

	List<Item> getAllItems();

	String addItem(Item item);

	ItemBookResponseDto bookItems(List<Long> itemIds);

	Item getExitingItemsById(Long id);

	String removeItemsById(Long id);

	String updateItem(Item item);

	String updateItemInventory(ItemInventoryRequestDto itemInventoryRequestDto);

}

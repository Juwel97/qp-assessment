package com.questionpro.grocery.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.grocery.dto.ItemBookResponseDto;
import com.questionpro.grocery.dto.ItemInventoryRequestDto;
import com.questionpro.grocery.model.Item;
import com.questionpro.grocery.repository.ItemRepository;
import com.questionpro.grocery.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	/* Here we have take care various negative scenario like
	 * 1.  Request is not proper so validating request is good idea -- not doing to make the code simple
	 * 2.  Handle various exception like item not available to user try to book -- not doing to make the code simple
	 * 3.  Business logic can be improve there are plenty of scope for that -- not doing here as time is shorten 
	 */
	
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Item> getAllItems() {
		
		return itemRepository.findAll();
	}

	@Override
	public String addItem(Item item) {
		itemRepository.save(item);
		return "Item save successfully.";
	}

	@Override
	public ItemBookResponseDto bookItems(List<Long> itemIds) {
		
		ItemBookResponseDto itemBookDto = new ItemBookResponseDto();
		List<Item> itemWithReduceStock = new ArrayList<>();
		List<Item> items = itemRepository.findAllById(itemIds);
		
		for( Item item : items) {
			if(item.getStock() > 0) {
				item.setStock(item.getStock() - 1);
				itemWithReduceStock.add(item);
			} else {
				// Item can not book as there is no stock avaialable.
			}
		}
		itemBookDto.setItemBooked(itemWithReduceStock);
		List<Long> itemBooked = itemWithReduceStock.stream().map(x -> x.getId()).toList();
		itemIds.removeAll(itemBooked);
		itemBookDto.setItemNotBooked(itemIds);
		return itemBookDto;
	}

	@Override
	public Item getExitingItemsById(Long id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public String removeItemsById(Long id) {
		itemRepository.deleteById(id);
		return "Item remove successfully";
	}

	@Override
	public String updateItem(Item item) {
		itemRepository.save(item);
		return "Item updated succesfully";
	}
	
	@Override
	public String updateItemInventory(ItemInventoryRequestDto itemInventoryRequestDto) {
		Item item = itemRepository.findById(itemInventoryRequestDto.getId()).get();
		item.setStock(item.getStock() + itemInventoryRequestDto.getStock());
		
		itemRepository.save(item);
		return "Inventory updated for item";
	}

}

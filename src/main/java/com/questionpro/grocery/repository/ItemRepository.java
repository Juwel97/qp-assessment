package com.questionpro.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionpro.grocery.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

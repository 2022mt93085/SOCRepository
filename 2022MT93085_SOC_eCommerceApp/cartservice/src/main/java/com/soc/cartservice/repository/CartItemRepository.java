package com.soc.cartservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.soc.cartservice.model.CartItem;
public interface CartItemRepository extends CrudRepository<CartItem, Integer>
{
}

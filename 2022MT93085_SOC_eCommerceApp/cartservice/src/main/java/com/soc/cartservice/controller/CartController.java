package com.soc.cartservice.controller;

import java.util.NoSuchElementException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soc.cartservice.model.Cart;
import com.soc.cartservice.model.CartItem;
import com.soc.cartservice.service.CartService;

@RestController
public class CartController 
{
@Autowired
CartService cartService;

@GetMapping("/carts/customers/{customerId}/cart")
private ResponseEntity<Object> getCustomerCart(@PathVariable("customerId") String customerid) throws JSONException 
{
	Cart retrievedCart = new Cart();
	try {
		retrievedCart = cartService.getCustomerCartById(customerid);
	}catch(NoSuchElementException ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Cart doesn't exist");
		jsonObj.put("errorCode", HttpStatus.NOT_FOUND.value());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObj.toString());	
	}
	
	return  ResponseEntity.status(HttpStatus.OK).body(retrievedCart);
}

@PutMapping("/carts/customers/{customerId}/cartitems")  
private ResponseEntity<Object> addToCart(@RequestBody CartItem cartItem, @PathVariable("customerId") String customerid) throws JSONException   
{  
	Cart createdCart = new Cart();
	try {
		createdCart = cartService.createOrAddToCart(cartItem, customerid);
	}catch(Exception ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Failed to create cart");
		jsonObj.put("errorCode", HttpStatus.BAD_REQUEST.value());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObj.toString());	
	}		
	return  ResponseEntity.status(HttpStatus.OK).body(createdCart); 
}

@DeleteMapping("/carts/customers/{customerId}/cartitems/{cartItemId}")  
private ResponseEntity<Object> removeFromCart(@PathVariable("cartItemId") int cartItemId, @PathVariable("customerId") String customerId) throws JSONException   
{  
	Cart updatedCart = new Cart();    
	
	JSONObject jsonObj = new JSONObject();
	try {
		updatedCart = cartService.removeFromCart(cartItemId, customerId);
	}catch(Exception ex) {
		ex.printStackTrace();
		jsonObj.put("errorMessage", "Failed to update/delete from cart");
		jsonObj.put("errorCode", HttpStatus.BAD_REQUEST.value());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObj.toString());	
	}

	return  ResponseEntity.status(HttpStatus.OK).body(updatedCart);
}

}

package com.soc.orderservice.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soc.orderservice.model.Order;
import com.soc.orderservice.service.OrderService;

@RestController
public class OrderController 
{

@Autowired
OrderService orderService;

@GetMapping("/orders/customers/{customerId}/orders")
private ResponseEntity<Object> getOrdersOfCustomer(@PathVariable("customerId") String customerId) throws JSONException 
{
	List<Order> orderList = new ArrayList();
	try {
		orderList = orderService.getCustomerOrdersById(customerId);
	}catch(NoSuchElementException ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Orders don't exist");
		jsonObj.put("errorCode", HttpStatus.NOT_FOUND.value());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObj.toString());	
	}
		
	return  ResponseEntity.status(HttpStatus.OK).body(orderList);

}

@PostMapping("/orders")
private ResponseEntity<Object> createOrder(@RequestBody Order order) throws JSONException 
{
	Order createdOrder = new Order();
	try {
		createdOrder = orderService.saveOrder(order);
	}catch(Exception ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Failed to create order");
		jsonObj.put("errorCode", HttpStatus.BAD_REQUEST.value());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObj.toString());	
	}	
	
	return  ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);

}

/*@PatchMapping("/orders/{orderId}/cancle")
private ResponseEntity<Object> cancleOrder(@RequestBody Order order) throws JSONException 
{
	Order retrievedOrder = new Order();
	try {
		retrievedOrder = orderService.cancleOrder(order);
	}catch(Exception ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Failed to cancle order");
		jsonObj.put("errorCode", HttpStatus.BAD_REQUEST.value());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObj.toString());	
	}		
	return  ResponseEntity.status(HttpStatus.OK).body(retrievedOrder);
}*/

@PatchMapping("/orders/{orderId}/cancle")
private ResponseEntity<Object> cancleOrder(@PathVariable("orderId") String orderId) throws JSONException 
{
	Order retrievedOrder = new Order();
	try {
		retrievedOrder = orderService.cancleOrder(orderId);
	}catch(Exception ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Failed to cancle order");
		jsonObj.put("errorCode", HttpStatus.BAD_REQUEST.value());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObj.toString());	
	}		
	return  ResponseEntity.status(HttpStatus.OK).body(retrievedOrder);
}


@PatchMapping("/orders/{orderId}/update")
private ResponseEntity<Object> updateOrder(@RequestBody Order order) throws JSONException 
{
	Order retrievedOrder = new Order();
	try {
		retrievedOrder = orderService.updateOrder(order);
	}catch(Exception ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Failed to update order");
		jsonObj.put("errorCode", HttpStatus.BAD_REQUEST.value());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObj.toString());	
	}		
	return  ResponseEntity.status(HttpStatus.OK).body(retrievedOrder);
}


}

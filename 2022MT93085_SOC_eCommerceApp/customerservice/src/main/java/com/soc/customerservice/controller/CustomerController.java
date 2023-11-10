package com.soc.customerservice.controller;
import java.util.NoSuchElementException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soc.customerservice.model.Customer;
import com.soc.customerservice.service.CustomerService;


//mark class as Controller
@RestController
public class CustomerController 
{
@Autowired
CustomerService customerService;

@PostMapping("/customers")
private ResponseEntity<Object> createCustomer(@RequestBody Customer customer) throws JSONException 
{
	System.out.println("========inside customer=======");
	Customer retrievedCustomer = new Customer();
	try {
		retrievedCustomer = customerService.createCustomer(customer);
	}catch(Exception ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Failed to create customer");
		jsonObj.put("errorCode", HttpStatus.BAD_REQUEST.value());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObj.toString());	
	}	
	
	return  ResponseEntity.status(HttpStatus.CREATED).body(retrievedCustomer);
}

@GetMapping("/customers/{customerId}")
//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customer doesn't exist")
private ResponseEntity<Object> getCustomer(@PathVariable("customerId") String customerid) throws JSONException 
{
	Customer customer = new Customer();
	try {
		customer = customerService.getCustomerById(customerid);
	}catch(NoSuchElementException ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Customer doesn't exist");
		jsonObj.put("errorCode", HttpStatus.NOT_FOUND.value());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObj.toString());	
	}
		
	return  ResponseEntity.status(HttpStatus.OK).body(customer);
}

@PatchMapping("/customers/{customerId}")
private ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable("customerId") String customerid) throws JSONException 
{
	Customer retrievedCustomer = new Customer();
	try {
		retrievedCustomer = customerService.updateCustomer(customer);
	}catch(Exception ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Failed to create customer");
		jsonObj.put("errorCode", HttpStatus.BAD_REQUEST.value());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObj.toString());	
	}		
	return  ResponseEntity.status(HttpStatus.OK).body(retrievedCustomer);
}

@DeleteMapping("/customers/{customerId}")
private ResponseEntity<String> deleteCustomer
(@PathVariable("customerId") String customerid) throws JSONException 
{
	JSONObject jsonObj = new JSONObject();
	try {
		customerService.deleteCustomer(customerid);
	}catch(Exception ex) {
		
		jsonObj.put("errorMessage", "Failed to create customer");
		jsonObj.put("errorCode", HttpStatus.BAD_REQUEST.value());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObj.toString());	
	}
	
	jsonObj.put("success", true);
	jsonObj.put("message", "Customer is deleted.");
	return  ResponseEntity.status(HttpStatus.OK).body(jsonObj.toString());
}


}

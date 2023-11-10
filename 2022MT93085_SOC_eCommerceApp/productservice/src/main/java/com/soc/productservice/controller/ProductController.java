package com.soc.productservice.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.soc.productservice.model.Product;
import com.soc.productservice.service.ProductService;
@RestController
public class ProductController 
{
@Autowired
ProductService productService;

@PostMapping("/products")
private ResponseEntity<Object> saveProduct(@RequestBody Product product) throws JSONException 
{
	Product retrievedProduct = new Product();
	try {
		retrievedProduct = productService.saveProduct(product);
	}catch(Exception ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Failed to create product");
		jsonObj.put("errorCode", HttpStatus.BAD_REQUEST.value());
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonObj.toString());	
	}	
	
	return  ResponseEntity.status(HttpStatus.CREATED).body(retrievedProduct);
}

@GetMapping("/products")
@ResponseBody
private ResponseEntity<Object> getProducts(@RequestParam String productName) throws JSONException 
{
	List<Product> retrievedProductList = new ArrayList();
	try {
		retrievedProductList = productService.getProductsByName(productName);
	}catch(NoSuchElementException ex) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("errorMessage", "Customer doesn't exist");
		jsonObj.put("errorCode", HttpStatus.NOT_FOUND.value());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonObj.toString());	
	}
		
	return  ResponseEntity.status(HttpStatus.OK).body(retrievedProductList);
}

}

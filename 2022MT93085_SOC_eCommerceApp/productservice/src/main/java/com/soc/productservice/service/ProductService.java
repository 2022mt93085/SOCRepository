package com.soc.productservice.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soc.productservice.model.Product;
import com.soc.productservice.repository.ProductRepository;
//defining the business logic
@Service
public class ProductService 
{
@Autowired
ProductRepository productRepository;
//getting all books record by using the method findaAll() of CrudRepository
public List<Product> getProductsByName(String productName) 
{
	List<Product> products = productRepository.findByProductNameContaining(productName);
	//for (Product product : ) {
		  //if(product.getProductName().contains(productName)) {
			 // orders.add(order);
		  //}
	//}
	return products;
}

//saving a specific record by using the method save() of CrudRepository
public Product saveProduct(Product product) 
{
	return productRepository.save(product);
}

}
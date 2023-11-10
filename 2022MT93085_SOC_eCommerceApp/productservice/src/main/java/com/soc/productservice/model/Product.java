package com.soc.productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


//mark class as an Entity 
@Entity
//defining class name as Table name
@Table(name="table_product")
public class Product
{
//Defining book id as primary key
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@GeneratedValue(generator = "product_id")
@GenericGenerator(name = "product_id", strategy = "com.soc.productservice.idgenerator.ProductIdGenerator")
private String productId;
@Column
private String productName;
@Column
private String productPrice;
@Column
private String productCategory;
@Column
private String productDescription;

public String getProductId() {
	return productId;
}
public String getProductName() {
	return productName;
}
public String getProductPrice() {
	return productPrice;
}
public String getProductCategory() {
	return productCategory;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public void setProductPrice(String productPrice) {
	this.productPrice = productPrice;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

}
package com.soc.orderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//mark class as an Entity 
@Entity
//defining class name as Table name
@Table(name="table_order_item")
public class OrderItem
{
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int orderItemId;

@Column
private int orderItemQuantity;
@Column
private String productId;	
@Column
private double orderItemPrice;
@Column
private String orderItemName;

/*
 * public int getOrderItemId() { return orderItemId; }
 */
public int getOrderItemQuantity() {
	return orderItemQuantity;
}
public String getProductId() {
	return productId;
}
public double getOrderItemPrice() {
	return orderItemPrice;
}
public void setOrderItemId(int orderItemId) {
	this.orderItemId = orderItemId;
}
public void setOrderItemQuantity(int orderItemQuantity) {
	this.orderItemQuantity = orderItemQuantity;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public void setOrderItemPrice(double orderItemPrice) {
	this.orderItemPrice = orderItemPrice;
}
public int getOrderItemId() {
	return orderItemId;
}
public String getOrderItemName() {
	return orderItemName;
}
public void setOrderItemName(String orderItemName) {
	this.orderItemName = orderItemName;
}

}
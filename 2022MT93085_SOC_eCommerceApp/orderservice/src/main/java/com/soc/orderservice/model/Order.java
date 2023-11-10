package com.soc.orderservice.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


//mark class as an Entity 
@Entity
//defining class name as Table name
@Table(name="table_order")
public class Order
{
	
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@GeneratedValue(generator = "order_id")
@GenericGenerator(name = "order_id", strategy = "com.soc.orderservice.idgenerator.OrderIdGenerator")
private String orderId;
@Column
private String orderStatus;
@Column
private String customerId;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "order_id")
@Column
private Set<OrderItem> orderItems = new HashSet<>();

@Column
private String orderCreationDate;	  
@Column
private String orderClosureDate;
@Column
private String orderAddress;

@Column
private boolean isProcured;
	
@Column
private boolean isShipped;

@Column
private boolean isDelivered;

public String getOrderId() {
	return orderId;
}

public String getOrderStatus() {
	return orderStatus;
}

public String getCustomerId() {
	return customerId;
}

public Set<OrderItem> getOrderItems() {
	return orderItems;
}

public String getOrderCreationDate() {
	return orderCreationDate;
}

public String getOrderClosureDate() {
	return orderClosureDate;
}

public boolean isProcured() {
	return isProcured;
}

public boolean isShipped() {
	return isShipped;
}

public boolean isDelivered() {
	return isDelivered;
}

public void setOrderId(String orderId) {
	this.orderId = orderId;
}

public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

public void setOrderItems(Set<OrderItem> orderItems) {
	this.orderItems = orderItems;
}

public void setOrderCreationDate(String orderCreationDate) {
	this.orderCreationDate = orderCreationDate;
}

public void setOrderClosureDate(String orderClosureDate) {
	this.orderClosureDate = orderClosureDate;
}

public void setProcured(boolean isProcured) {
	this.isProcured = isProcured;
}

public void setShipped(boolean isShipped) {
	this.isShipped = isShipped;
}

public void setDelivered(boolean isDelivered) {
	this.isDelivered = isDelivered;
}

public String getOrderAddress() {
	return orderAddress;
}

public void setOrderAddress(String orderAddress) {
	this.orderAddress = orderAddress;
}


}
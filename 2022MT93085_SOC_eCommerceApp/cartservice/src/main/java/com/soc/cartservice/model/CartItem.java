package com.soc.cartservice.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_cart_item")
public class CartItem
{	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int cartItemId;
@Column
private String cartItemName;
@Column
private double cartItemPrice;
@Column
private int cartItemQuantity;
@Column
private String productId;

public int getCartItemId() {
	return cartItemId;
}
public String getCartItemName() {
	return cartItemName;
}
public double getCartItemPrice() {
	return cartItemPrice;
}
public int getCartItemQuantity() {
	return cartItemQuantity;
}
public void setCartItemId(int cartItemId) {
	this.cartItemId = cartItemId;
}
public void setCartItemName(String cartItemName) {
	this.cartItemName = cartItemName;
}
public void setCartItemPrice(double cartItemPrice) {
	this.cartItemPrice = cartItemPrice;
}
public void setCartItemQuantity(int cartItemQuantity) {
	this.cartItemQuantity = cartItemQuantity;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}

}
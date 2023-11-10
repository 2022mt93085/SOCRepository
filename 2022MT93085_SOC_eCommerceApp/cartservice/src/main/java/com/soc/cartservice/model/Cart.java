package com.soc.cartservice.model;

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
 
@Entity
@Table(name="table_cart")
public class Cart
{
	
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@GeneratedValue(generator = "cart_id")
@GenericGenerator(name = "cart_id", strategy = "com.soc.cartservice.idgenerator.CartIdGenerator")
private String cartId;

@Column
private String customerId;

@Column
private String cartStatus;

@Column
private String cartCreationDate;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "cart_id")
@Column
private Set<CartItem> cartItems = new HashSet<>();

@Column
private double cartTotalPrice;

public String getCartId() {
	return cartId;
}

public String getCustomerId() {
	return customerId;
}

public Set<CartItem> getCartItems() {
	return cartItems;
}

public void setCartId(String cartId) {
	this.cartId = cartId;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

public void setCartItems(Set<CartItem> cartItems) {
	this.cartItems = cartItems;
}

public String getCartStatus() {
	return cartStatus;
}

public String getCartCreationDate() {
	return cartCreationDate;
}

public void setCartStatus(String cartStatus) {
	this.cartStatus = cartStatus;
}

public void setCartCreationDate(String cartCreationDate) {
	this.cartCreationDate = cartCreationDate;
}

public Double getCartTotalPrice() {
    return cartTotalPrice;
}

public void setCartTotalPrice(double cartTotalPrice) {
	this.cartTotalPrice = cartTotalPrice;
}

public double calculateCartTotalPrice(Cart cart) {
    double total = 0.0;
    Set<CartItem> items = cart.getCartItems();
    for (CartItem item : items) {
    	total += (item.getCartItemPrice()*item.getCartItemQuantity());
    }
	return total;
}

public void add(CartItem cartItem) {

    if (cartItem != null) {
        if (cartItems == null) {
        	cartItems = new HashSet<>();
        }

        cartItems.add(cartItem);
       // item.setOrder(this);
    }
}

public void remove(CartItem cartItem) {
    if (cartItem != null) {
        if (cartItems != null) 
        cartItems.remove(cartItem);
    }
}

}
package com.soc.cartservice.service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soc.cartservice.model.Cart;
import com.soc.cartservice.model.CartItem;
import com.soc.cartservice.repository.CartItemRepository;
import com.soc.cartservice.repository.CartRepository;
//defining the business logic
@Service
public class CartService 
{
@Autowired
CartRepository cartRepository;
@Autowired
CartItemRepository cartItemRepository;
private Cart currentCart;

//getting a specific record by using the method findById() of CrudRepository
public Cart createOrAddToCart(CartItem cartItem,String customerId) 
{
	Cart currentCart = cartRepository.findCartByCustomerId(customerId, "Pending");
	if(currentCart == null) {
		currentCart = new Cart();
		currentCart.add(cartItem);
		currentCart.setCustomerId(customerId);
		currentCart.setCartStatus("Pending");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		currentCart.setCartCreationDate(dateFormat.format(Calendar.getInstance().getTime()));
		currentCart.setCartTotalPrice(currentCart.calculateCartTotalPrice(currentCart));
		cartRepository.save(currentCart);
	}else {
		currentCart.add(cartItem);
		currentCart.setCartTotalPrice(currentCart.calculateCartTotalPrice(currentCart));
		cartRepository.save(currentCart);
	}
	
	return currentCart;
}

//getting a specific record by using the method findById() of CrudRepository
public Cart removeFromCart(int cartItemId,String customerId) 
{
	currentCart = cartRepository.findCartByCustomerId(customerId, "Pending");

	if(currentCart != null || currentCart.getCartItems().size()>0) {
		for (CartItem item : currentCart.getCartItems()) {
	    	if(item.getCartItemId()== cartItemId) {
	    		currentCart.remove(item);	    		
	    	}
	    }		
		currentCart.setCartTotalPrice(currentCart.calculateCartTotalPrice(currentCart));
		
	}else {
		currentCart.setCartTotalPrice(0.0);
	}
	
	cartRepository.save(currentCart);
	cartItemRepository.deleteById(cartItemId);
	return currentCart;
	
	/*System.out.println("inside ");
	cartRepository.deleteById(cartItemId);
	Cart currentCart = cartRepository.findCartByCustomerId(customerId, "Pending");
	System.out.println("currentCart.getCartItems().size() :"+ currentCart.getCartItems().size());
	if(currentCart != null || currentCart.getCartItems().size()>0) {
		currentCart.setCartTotalPrice(currentCart);
		cartRepository.save(currentCart);
	}	
	return currentCart;*/
}

//getting a specific record by using the method findById() of CrudRepository
public Cart getCustomerCartById(String customerid) 
{
	return cartRepository.findCartByCustomerId(customerid, "Pending");
}


}
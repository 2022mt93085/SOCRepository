package com.soc.orderservice.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soc.orderservice.model.Order;
import com.soc.orderservice.repository.OrderRepository;
//defining the business logic
@Service
public class OrderService 
{
@Autowired
OrderRepository orderRepository;
//getting all books record by using the method findaAll() of CrudRepository
public List<Order> getCustomerOrdersById(String customerId) 
{
	List<Order> orders = new ArrayList<Order>();
	for (Order order : orderRepository.findAll()) {
		  if(order.getCustomerId().equals(customerId)) {
			  orders.add(order);
		  }
	}
	return orders;
}

//saving a specific record by using the method save() of CrudRepository
public Order saveOrder(Order order) 
{
	return orderRepository.save(order);
}

//saving a specific record by using the method save() of CrudRepository
public Order cancleOrder(String orderId) 
{
	Order order = orderRepository.findOrderByOrderId(orderId);
	order.setOrderStatus("Cancelled");
	return orderRepository.save(order);
}

//saving a specific record by using the method save() of CrudRepository
public Order updateOrder(Order order) 
{
	return orderRepository.save(order);
}

}
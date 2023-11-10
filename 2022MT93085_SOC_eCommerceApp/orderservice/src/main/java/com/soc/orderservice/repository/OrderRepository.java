package com.soc.orderservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.soc.orderservice.model.Order;
public interface OrderRepository extends CrudRepository<Order, String>, JpaRepository<Order, String>
{
	Order findOrderByOrderId(@Param("orderId") String orderId);
}

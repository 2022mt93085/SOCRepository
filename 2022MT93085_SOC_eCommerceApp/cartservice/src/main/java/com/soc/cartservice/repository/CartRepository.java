package com.soc.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.soc.cartservice.model.Cart;
public interface CartRepository extends JpaRepository<Cart, Integer>
{
	@Query("SELECT c FROM Cart c WHERE (:customerId is null or c.customerId = :customerId) and (:cartStatus is null or c.cartStatus = :cartStatus)")
	Cart findCartByCustomerId(@Param("customerId") String customerId, @Param("cartStatus") String cartStatus);
}

package com.soc.customerservice.repository;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.soc.customerservice.model.Customer;
import com.soc.customerservice.model.CustomerAddress;


//import com.soc.ecommerceproject.model.Cart;
public interface CustomerRepository extends JpaRepository<Customer, String>, CrudRepository<Customer, String>
{
	//List<Cart> findCartByCustomerId(@Param("cartId") String cartId);
	Set<CustomerAddress> findCustomerAddressByCustomerId(@Param("customerId") String customerId);
}

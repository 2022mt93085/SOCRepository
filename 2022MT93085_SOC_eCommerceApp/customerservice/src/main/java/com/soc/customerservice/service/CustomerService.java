package com.soc.customerservice.service;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soc.customerservice.model.Customer;
import com.soc.customerservice.repository.CustomerRepository;


//defining the business logic
@Service
public class CustomerService 
{
@Autowired
CustomerRepository customerRepository;
//getting all books record by using the method findaAll() of CrudRepository
public List<Customer> getAllCustomers() 
{
List<Customer> customers = new ArrayList<Customer>();
customerRepository.findAll().forEach(customer1 -> customers.add(customer1));
return customers;
}
//getting a specific record by using the method findById() of CrudRepository
public Customer getCustomerById(String id) 
{
return customerRepository.findById(id).get();
}
//saving a specific record by using the method save() of CrudRepository
public Customer createCustomer(Customer customer) 
{
	return customerRepository.save(customer);
}
//deleting a specific record by using the method deleteById() of CrudRepository
public void deleteCustomer(String id) 
{
	customerRepository.deleteById(id);
}
//updating a record
public Customer updateCustomer(Customer customer) 
{
	return customerRepository.save(customer);
}

}
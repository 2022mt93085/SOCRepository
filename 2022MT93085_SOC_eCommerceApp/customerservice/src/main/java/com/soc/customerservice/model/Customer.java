package com.soc.customerservice.model;
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
@Table(name="table_customer")
public class Customer
{
//Defining book id as primary key
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@GeneratedValue(generator = "customer_id")
@GenericGenerator(name = "customer_id", strategy = "com.soc.customerservice.idgenerator.CustomerIdGenerator")
private String customerId;
@Column
private String customerFirstName;
@Column
private String customerLastName;
@Column
private String customerEmailId;
@Column
private long customerContact;

/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "customer_id")
private Set<CustomerAddress> customerAddress;*/

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "customer_id")
private Set<CustomerAddress> customerAddress = new HashSet<>();

public void add(CustomerAddress custAddress) {

    if (custAddress != null) {
        if (customerAddress == null) {
        	customerAddress = new HashSet<>();
        }

        customerAddress.add(custAddress);
       // item.setOrder(this);
    }
}

public void remove(CustomerAddress custAddress) {

    if (custAddress != null) {
        if (customerAddress != null) {
        	customerAddress.remove(custAddress);
        }      
       // item.setOrder(this);
    }
}

public String getCustomerId() {
	return customerId;
}

public String getCustomerFirstName() {
	return customerFirstName;
}

public String getCustomerLastName() {
	return customerLastName;
}

public String getCustomerEmailId() {
	return customerEmailId;
}

public long getCustomerContact() {
	return customerContact;
}

public Set<CustomerAddress> getCustomerAddress() {
	return customerAddress;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

public void setCustomerFirstName(String customerFirstName) {
	this.customerFirstName = customerFirstName;
}

public void setCustomerLastName(String customerLastName) {
	this.customerLastName = customerLastName;
}

public void setCustomerEmailId(String customerEmailId) {
	this.customerEmailId = customerEmailId;
}

public void setCustomerContact(long customerContact) {
	this.customerContact = customerContact;
}

public void setCustomerAddress(Set<CustomerAddress> customerAddress) {
	this.customerAddress = customerAddress;
}

@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", customerFirstName=" + customerFirstName + ", customerLastName="
			+ customerLastName + ", customerEmailId=" + customerEmailId + ", customerContact=" + customerContact
			+ ", customerAddress=" + customerAddress + "]";
}



}
package com.soc.customerservice.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity 
@Entity
//defining class name as Table name
@Table(name="table_customer_address")
public class CustomerAddress
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

/*@ManyToOne(cascade = CascadeType.ALL)
private Customer customer;*/

@Column
private String house;
@Column
private String lane;
@Column
private String landmark;
@Column
private String city;
@Column
private String state;
@Column
private int pin;
@Column
private String addressType;

/*public Customer getCustomer() {
	return customer;
}*/
public int getId() {
	return id;
}
public String getHouse() {
	return house;
}
public String getLane() {
	return lane;
}
public String getLandmark() {
	return landmark;
}
public String getCity() {
	return city;
}
public String getState() {
	return state;
}
public int getPin() {
	return pin;
}
public String getAddressType() {
	return addressType;
}
/*public void setCustomer(Customer customer) {
	this.customer = customer;
}*/
public void setId(int id) {
	this.id = id;
}
public void setHouse(String house) {
	this.house = house;
}
public void setLane(String lane) {
	this.lane = lane;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}
public void setCity(String city) {
	this.city = city;
}
public void setState(String state) {
	this.state = state;
}
public void setPin(int pin) {
	this.pin = pin;
}
public void setAddressType(String addressType) {
	this.addressType = addressType;
}

}
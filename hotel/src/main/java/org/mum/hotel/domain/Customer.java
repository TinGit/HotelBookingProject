package org.mum.hotel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Email;

@Entity
public class Customer {
	@Id @GeneratedValue
	private int customerNo; 
	private String firstName; 
	private String lastName;
	private String email; 
	private String phone; 
	private String street; 
	private String city; 
	private String state;
	
	public Customer(){}
	
	public Customer(String fname,String lname,String email,String phone,String street,String city,String state){
		this.firstName=fname;
		this.lastName = lname;
		this.email=email;
		this.phone=phone;
		this.street=street;
		this.city=city;
		this.state=state;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	} 
	
	 
	
	
}

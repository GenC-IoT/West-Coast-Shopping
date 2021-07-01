package com.example.demo;

public class Customer {
	private String customerID;
	private String companyName;
	private String contactName;
	private String street;
	private String city;
	private String state;

	public Customer(String customerID, String companyName, String contactName, String street, String city,
			String state) {
		super();
		this.customerID = customerID;
		this.companyName = companyName;
		this.contactName = contactName;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	
	public Customer() {
		super();
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", companyName=" + companyName + ", contactName=" + contactName
				+ ", street=" + street + ", city=" + city + ", state=" + state + "]";
	}
	
	

}
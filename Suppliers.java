package com.test;

public class Suppliers {
	private long supplierID;
	private String companyName;
	private String contactName;

	public Suppliers(long supplierID, String companyName, String contactName) {
		super();
		this.supplierID = supplierID;
		this.companyName = companyName;
		this.contactName = contactName;
	}

	public Suppliers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(long supplierID) {
		this.supplierID = supplierID;
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

	@Override
	public String toString() {
		return "Suppliers [supplierID=" + supplierID + ", companyName=" + companyName + ", contactName=" + contactName
				+ "]";
	}

}

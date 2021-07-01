package com.example.demo;

public class Product {
	private long productID;
	private String productName;
	private long supplierID;
	private long categoryID;
	private double unitPrice;

	public Product(long productID, String productName, long supplierID, long categoryID, double unitPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.supplierID = supplierID;
		this.categoryID = categoryID;
		this.unitPrice = unitPrice;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(long supplierID) {
		this.supplierID = supplierID;
	}

	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", supplierID=" + supplierID
				+ ", categoryID=" + categoryID + ", unitPrice=" + unitPrice + "]";
	}

}

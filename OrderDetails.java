package com.test;

public class OrderDetails {
	private long orderId;
	private long productID;
	private short quantity;

	public OrderDetails(long orderId, long productID, short quantity) {
		super();
		this.orderId = orderId;
		this.productID = productID;
		this.quantity = quantity;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", productID=" + productID + ", quantity=" + quantity + "]";
	}

}

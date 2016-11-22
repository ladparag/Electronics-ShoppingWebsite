package com.electronicshop.pojo;

public class AddCart {
	
	private int custId;
	private String userName;
	private int itemId;
	private String itemName;
	private int quantity;
	private float price;
	private float total;
	private String orderDate;
	@Override
	public String toString() {
		return "AddCart [custId=" + custId + ", userName=" + userName + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", quantity=" + quantity + ", price=" + price + ", total=" + total + ", orderDate=" + orderDate + "]";
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
	

}

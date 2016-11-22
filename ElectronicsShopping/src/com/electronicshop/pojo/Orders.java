package com.electronicshop.pojo;

public class Orders {
	
	private int cartId;
	private int custId;
	private String custName;
	private String itemName;
	private int quantity;
	private float price;
	private float total;
	
	@Override
	public String toString() {
		return "Orders [cartId=" + cartId + ", custId=" + custId + ", custName=" + custName + ", itemName=" + itemName
				+ ", quantity=" + quantity + ", price=" + price + ", total=" + total + "]";
	}
	
	

	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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

	
}

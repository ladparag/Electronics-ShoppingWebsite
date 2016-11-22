package com.electronicshop.pojo;

public class Cart {
	
	private int cartId;
	private int catId;
	private int custId;
	private String userName;
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String itemName;
	private int quantity;
	private float total;
	private String image;
	private float price;
	private String orderDate;
	private int totalQuantity;
	private float finalTotal;
	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", catId=" + catId + ", custId=" + custId + ", userName=" + userName
				+ ", email=" + email + ", itemName=" + itemName + ", quantity=" + quantity + ", total=" + total
				+ ", image=" + image + ", price=" + price + ", orderDate=" + orderDate + ", totalQuantity="
				+ totalQuantity + ", finalTotal=" + finalTotal + "]";
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public float getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(float finalTotal) {
		this.finalTotal = finalTotal;
	}
	
	
	

}

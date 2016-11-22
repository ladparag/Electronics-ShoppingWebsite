package com.electronicshop.pojo;

public class History {
	
	private String itemName;
	private int quantity;
	private float price;
	private float total;
	private String image;
	
	@Override
	public String toString() {
		return "History [itemName=" + itemName + ", quantity=" + quantity + ", price=" + price + ", total=" + total
				+ ", image=" + image + "]";
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}

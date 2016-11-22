package com.electronicshop.pojo;

public class InsertCart {
	
	private int itemId;
	private int catId;
	private String itemName;
	private String description;
	private String image;
	private int quantity;
	private float price;
	private int stocks;
	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	private float total;
	
	@Override
	public String toString() {
		return "InsertCart [itemId=" + itemId + ", catId=" + catId + ", itemName=" + itemName + ", description="
				+ description + ", image=" + image + ", quantity=" + quantity + ", price=" + price + ", stocks="
				+ stocks + ", total=" + total + "]";
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

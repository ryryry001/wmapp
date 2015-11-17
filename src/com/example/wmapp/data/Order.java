package com.example.wmapp.data;



public class Order {
	
	
	private int orderNumber;
    private String time;
	private String status;
	private String shopName;
	private int shopId;
	private int price;
	
	public Order(int orderNumber, String time, String status, String shopName,
			int shopId, int price) {
		
		this.orderNumber = orderNumber;
		this.time = time;
		this.status = status;
		this.shopName = shopName;
		this.shopId = shopId;
		this.price = price;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
}

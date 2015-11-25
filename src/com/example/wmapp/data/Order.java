package com.example.wmapp.data;



public class Order {
	
	
	private String orderNumber;
    private String time;
	private String status;
	private String shopName;
	private String shopId;
	private String price;
	private String arriveTime;
	
	public Order(String orderNumber,String time, String status,
			String shopName, String shopID, String price,String arriveTime){
		this.orderNumber = orderNumber;
		this.time = time;
		this.status = status;
		this.shopName = shopName;
		this.shopId = shopID;
		this.price = price;
		this.arriveTime = arriveTime;
	}
	
	public Order(){
		
	}
	
	public String getArriveTime() {
		return this.arriveTime;
	}
	
	public void set(String arriveTime){
		this.arriveTime = arriveTime;
	}
	
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
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

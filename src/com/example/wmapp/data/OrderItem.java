package com.example.wmapp.data;

public class OrderItem {

	private String name;
	private int dishID;
	private int num;
	private float price;
	
	public OrderItem(String name, int dishID, int num, float price){
		this.name = name;
		this.dishID = dishID;
		this.num = num;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDishID() {
		return dishID;
	}

	public void setDishID(int dishID) {
		this.dishID = dishID;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}

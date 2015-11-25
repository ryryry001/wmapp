package com.example.wmapp.data;

public class Dish {
	private String name;
	private String url;
	private int dishID;
	private float score;
	private float price;
	
	public Dish(String name, String url, int id, float score, float price){
		this.name = name;
		this.url = url;
		this.dishID = id;
		this.score = score;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getDishID() {
		return dishID;
	}
	public void setDishID(int dishID) {
		this.dishID = dishID;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	

}

package com.example.wmapp.data;

public class Shop {
	private String name;
	private String url;
	private String discountDes;
	private int sales;
    private int deliveryfee;
    private int discountType;
    private int discountPrice;
    private int time;
    private int minConsumption;
    private float score;
    
    public Shop(String name,String url,int sales,float score,int deliveryfee,
    		int discountType,String discountDes,int time, int minConsumption) {
    	this.name = name;
    	this.url = url;
    	this.sales = sales;
    	this.score = score;
    	this.deliveryfee = deliveryfee;
    	this.discountType = discountType;
    	this.discountDes = discountDes;
    	this.time = time;
    	this.minConsumption = minConsumption;
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

	public String getDiscountDes() {
		return discountDes;
	}

	public void setDiscountDes(String discountDes) {
		this.discountDes = discountDes;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getDeliveryfee() {
		return deliveryfee;
	}

	public void setDeliveryfee(int deliveryfee) {
		this.deliveryfee = deliveryfee;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getMinConsumption() {
		return minConsumption;
	}

	public void setMinConsumption(int minConsumption) {
		this.minConsumption = minConsumption;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
}

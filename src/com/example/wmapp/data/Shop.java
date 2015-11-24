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
}

package com.example.wmapp.data;

import java.util.ArrayList;

public class ShopListData {

	private ArrayList<Shop> listData;
	private static ShopListData instance;
	
	private ShopListData(){
		listData = new ArrayList<Shop>();
		getDataFromNetwork();
	}
	
	public static ShopListData getInstance(){
		if(instance == null){
			synchronized(ShopListData.class){
				if(instance == null){
					instance = new ShopListData();
				}
			}
		}
		return instance;
	}
	
	public ArrayList<Shop> getShopList(){
		return this.listData;
	}
	
	public void refreshData(){
		getDataFromNetwork();
	}
	
	/**
	 * 从服务器获取商户数据
	 */
	private void getDataFromNetwork(){
		//这里仅用作测试，自己建立几个数据
		listData.clear();
		listData.add(new Shop("绝味排骨",null,120,4.0f,0,0,"首单减10元",30,10));
		listData.add(new Shop("桃园食堂",null,110,4.0f,0,0,"首单减10元",30,20));
	}
	
}

package com.example.wmapp.data;

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Log;

public class ShopChooseBarData {
	
	private ArrayList<String> shopTypeList;
	private HashMap<String,ArrayList<String>> subLists;
	private ArrayList<String> sortList;
	private ArrayList<String> discountList;
	private static ShopChooseBarData instance;
	
	private ShopChooseBarData(){
		shopTypeList = new ArrayList<String>();
		subLists = new HashMap<String,ArrayList<String>>();
		sortList = new ArrayList<String>();
		discountList = new ArrayList<String>();
		initData();
	}
	
	private void initData(){
		shopTypeList.add("全部商家");
		shopTypeList.add("快餐类");
		shopTypeList.add("正餐类");
		ArrayList<String> sub1 = new ArrayList<String>();
		sub1.add("全部快餐类");
		sub1.add("盖浇饭");
		sub1.add("中式炒菜");
		sub1.add("米粉面馆");
		sub1.add("饺子馄饨");
		subLists.put("快餐类", sub1);
		ArrayList<String> sub2 = new ArrayList<String>();
		sub2.add("川湘菜");
		sub2.add("江浙菜");
		sub2.add("粤菜");
		sub2.add("新疆菜");
		subLists.put("正餐类", sub2);
		sortList.add("智能排序");
		sortList.add("距离最近");
		sortList.add("销量最高");
		sortList.add("起送价最低");
		sortList.add("送餐最快");
		sortList.add("评价最好");
		discountList.add("首单立减");
		discountList.add("折扣商品");
		discountList.add("满减优惠");
		discountList.add("满返代金券");
		discountList.add("免费配送");
		discountList.add("0元起送");
	}
	
	public ArrayList<String> getTypeList(){
		return shopTypeList;
	}
	
	public ArrayList<String> getSubList(String key){
		return subLists.get(key);
	}
	
	public ArrayList<String> getSortList(){
		return this.sortList;
	}
	
	public ArrayList<String> getDiscountList(){
		return this.discountList;
	}

	public static ShopChooseBarData getInstance(){
		if(instance == null){
			synchronized(ShopChooseBarData.class){
				if(instance == null){
					instance = new ShopChooseBarData();
				}
			}
		}
		return instance;
	}
}

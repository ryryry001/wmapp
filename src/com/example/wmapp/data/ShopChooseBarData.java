package com.example.wmapp.data;

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Log;

public class ShopChooseBarData {
	
	private ArrayList<String> shopTypeList;
	private HashMap<String,ArrayList<String>> subLists;
	private static ShopChooseBarData instance;
	
	private ShopChooseBarData(){
		shopTypeList = new ArrayList<String>();
		subLists = new HashMap<String,ArrayList<String>>();
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
	}
	
	public ArrayList<String> getTypeList(){
		return shopTypeList;
	}
	
	public ArrayList<String> getSubList(String key){
		return subLists.get(key);
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

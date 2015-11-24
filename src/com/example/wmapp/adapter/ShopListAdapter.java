package com.example.wmapp.adapter;

import java.util.ArrayList;

import com.example.wmapp.data.Shop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ShopListAdapter extends BaseAdapter{
	
	private ArrayList<Shop> list;
	private Context context;
	
	public ShopListAdapter(ArrayList<Shop> list,Context context){
	    this.list = list;	
	    this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}

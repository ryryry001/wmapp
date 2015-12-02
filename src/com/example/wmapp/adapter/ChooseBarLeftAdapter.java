package com.example.wmapp.adapter;

import java.util.ArrayList;

import com.example.wmapp.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChooseBarLeftAdapter extends BaseAdapter {

	private ArrayList<String> typeList;
	private Context context;
	private int typeSelectIndex = 0;
	private int discountSelectIndex = -1;
	private int sortSelectIndex = -1;
	private int listType = 1;
	
	public void setListType(int i){
		this.listType = i;
	}
	
	public void setTypeSelectIndex(int i){
		this.typeSelectIndex = i;
	}
	
	public void setDiscountSelectIndex(int i){
		this.discountSelectIndex = i;
	}
	
	public void setSortSelectIndex(int i){
		this.sortSelectIndex = i;
	}
	
	public ChooseBarLeftAdapter(Context context, ArrayList<String> list){
		this.typeList = list;
		this.context = context;
	}
	
	public ArrayList<String> getList(){
		return this.typeList;
	}
	
	public void setList(ArrayList<String> list) {
		this.typeList = list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return typeList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return typeList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.choosebar_list_item, null);
			holder.icon = (ImageView)convertView.findViewById(R.id.icon);
			holder.leftText = (TextView)convertView.findViewById(R.id.choosebarlistitemleft);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.leftText.setText((String)getItem(position));
		if(listType == 1){
			if(position == typeSelectIndex){
				convertView.setBackgroundColor(Color.WHITE);
			} else {
				convertView.setBackgroundColor(Color.LTGRAY);
			}
		} else if(listType == 2){
			if(position == sortSelectIndex){
				convertView.setBackgroundColor(Color.WHITE);
			} else {
				convertView.setBackgroundColor(Color.LTGRAY);
			}
		} else {
			if(position == discountSelectIndex){
				convertView.setBackgroundColor(Color.WHITE);
			} else {
				convertView.setBackgroundColor(Color.LTGRAY);
			}
		}
		
		return convertView;
	}
	
	private static class ViewHolder{
		private ImageView icon;
		private TextView leftText;
	}

}

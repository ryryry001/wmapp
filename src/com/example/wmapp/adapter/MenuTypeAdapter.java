package com.example.wmapp.adapter;

import java.util.ArrayList;

import com.example.wmapp.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MenuTypeAdapter extends BaseAdapter{
	
	private Context context;
	private ArrayList<String> list;
	private int selectIndex;
	
	public MenuTypeAdapter(Context context,ArrayList<String> list){
		this.context = context;
		this.list = list;
		selectIndex = 0;
	}
	
	public void setSelectIndex(int i){
		selectIndex = i;
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
		ViewHolder holder = null;
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.type_list_item, null);
			holder = new ViewHolder();
			holder.type = (TextView) convertView.findViewById(R.id.typeText);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.type.setText((String)getItem(position));
		if(position == selectIndex){
			convertView.setBackgroundColor(Color.WHITE);
		} else {
			convertView.setBackgroundColor(Color.TRANSPARENT);
		}
		return convertView;
	}

	public static class ViewHolder{
		private TextView type;
	}
	
}

package com.example.wmapp.adapter;

import java.util.ArrayList;

import com.example.wmapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ChooseBarRightAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<String> list;
	
	public ChooseBarRightAdapter(Context context, ArrayList<String> list){
		this.context = context;
		this.list = list;
	}
	
	public void setList(ArrayList<String> list){
		this.list = list;
	}
	
	public ArrayList<String> getList(){
		return this.list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(list == null){
			return 0;
		} else {
			return list.size();	
		}
	}

	@Override
	public Object getItem(int position) {
		if(list==null){
			return null;
		}
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.choosebar_sub_list_item, null);
			holder.text = (TextView)convertView.findViewById(R.id.subText);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder)convertView.getTag();
		}
		holder.text.setText((String)getItem(position));
		return convertView;
	}
	
	private static class ViewHolder{
		private TextView text;
	}

}

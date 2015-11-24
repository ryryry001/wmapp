package com.example.wmapp.adapter;

import java.util.ArrayList;

import com.example.wmapp.R;
import com.example.wmapp.data.Shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.collection_list_item, null);
			holder.image = (ImageView)convertView.findViewById(R.id.collectionlistitemshopImage);
			holder.scoreImage = (ImageView)convertView.findViewById(R.id.collectionlistitemstarImage);
			holder.name = (TextView)convertView.findViewById(R.id.collectionlistitemshopText);
			holder.charge = (TextView)convertView.findViewById(R.id.collectionlistitemchargeText);
			holder.discountLayout = (LinearLayout)convertView.findViewById(R.id.collectionlistitemdiscountLayout);
		    holder.time = (TextView)convertView.findViewById(R.id.collectionlistitemminuteText);
		    holder.sale = (TextView)convertView.findViewById(R.id.collectionlistitemsalesText);
		    convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Shop shop = (Shop) getItem(position);
		holder.name.setText(shop.getName());
		holder.sale.setText("月售"+shop.getSales()+"单");
		holder.charge.setText("起送价¥"+ shop.getMinConsumption()+"｜配送费"+shop.getDeliveryfee());
		//holder.time.setText(shop.getTime());
		return convertView;
	}
	
	public static class ViewHolder{
		private ImageView image;
		private ImageView scoreImage;
		private TextView name;
		private TextView sale;
		private TextView time;
		private TextView charge;
		private LinearLayout discountLayout;
	}

}

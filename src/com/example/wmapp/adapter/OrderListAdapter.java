package com.example.wmapp.adapter;

import java.util.ArrayList;

import com.example.wmapp.R;
import com.example.wmapp.data.Order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderListAdapter extends BaseAdapter{

	private ArrayList<Order> orders;
	private Context context;
	
	public OrderListAdapter(Context context, ArrayList<Order> orders) {
		this.orders = orders;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return orders.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return orders.get(position);
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
			convertView = LayoutInflater.from(context).inflate(R.layout.order_list_item, null);
			holder = new ViewHolder();
			holder.time = (TextView) convertView.findViewById(R.id.orderlistitemTime);
			holder.status = (TextView) convertView.findViewById(R.id.orderlistitemStatus);
			holder.shopName = (TextView) convertView.findViewById(R.id.orderlistitemshopText);
			holder.price = (TextView) convertView.findViewById(R.id.orderlistitempriceText);
			holder.arriveTime = (TextView) convertView.findViewById(R.id.arriveTime);
			holder.shopImage = (ImageView) convertView.findViewById(R.id.orderlistitemshopImage);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
        Order order= (Order) getItem(position);
        holder.time.setText(order.getTime());
	    holder.status.setText(order.getStatus());
	    holder.shopName.setText(order.getShopName());
	    holder.price.setText("¥"+order.getPrice());
        if(order.getArriveTime().equals("-1")){
		    holder.arriveTime.setText("再来一份");
		} else {
		    holder.arriveTime.setText(order.getArriveTime()+" 分钟送达");
		}
		    
		return convertView;
	}
	
	public static class ViewHolder{
		private TextView time;
		private TextView status;
		private TextView shopName;
		private TextView price;
		private TextView arriveTime;
		private ImageView shopImage;
	}

}

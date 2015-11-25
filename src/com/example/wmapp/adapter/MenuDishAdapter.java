package com.example.wmapp.adapter;

import java.util.ArrayList;

import com.example.wmapp.R;
import com.example.wmapp.data.Dish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuDishAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Dish> list;
	
	public MenuDishAdapter(Context context, ArrayList<Dish> list){
		this.context = context;
		this.list = list;
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
		if(convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.dish_list_item, null);
			holder.dishimage = (ImageView) convertView.findViewById(R.id.dishImage);
			holder.dishscore = (ImageView) convertView.findViewById(R.id.dishscoreImage);
			holder.dishText = (TextView) convertView.findViewById(R.id.dishnameText);
			holder.dishprice = (TextView) convertView.findViewById(R.id.dishpriceText);
			holder.add = (ImageView) convertView.findViewById(R.id.addImage);
			holder.num = (TextView) convertView.findViewById(R.id.numText);
			holder.delete = (ImageView) convertView.findViewById(R.id.deleteImage);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Dish dish = (Dish) getItem(position);
		holder.dishText.setText(dish.getName());
		holder.dishprice.setText("¥"+dish.getPrice());
		holder.add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int[] location = new int[2];
				v.getLocationOnScreen(location);
				Toast.makeText(context, location[0]+"/"+location[1], Toast.LENGTH_SHORT).show();
			}
			
		});
		return convertView;
	}
	
	public static class ViewHolder{
		private ImageView dishimage;
		private ImageView dishscore;
		private ImageView add;
		private ImageView delete;
		private TextView dishText;
		private TextView dishprice;
		private TextView num;
	}

}

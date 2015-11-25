package com.example.wmapp.fragments;

import com.example.wmapp.R;
import com.example.wmapp.adapter.MenuDishAdapter;
import com.example.wmapp.adapter.MenuTypeAdapter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuFragment extends Fragment implements OnClickListener,OnItemClickListener{

	private OnMenuClickListener listener;
	private TextView arriveTime;
	private TextView titleleft;
	private TextView titlecenter;
	private TextView titleright;
	private ListView typelist;
	private ListView dishlist;
	private final int defalutColor = Color.parseColor("#ff7f50");
	private int selectTypeIndex = 0;
	private String shopName;
	private MenuTypeAdapter typeAdapter;
	private MenuDishAdapter dishAdapter;
	
	public interface OnMenuClickListener{
		public void onMenuClick(int intent);
	}
	
	public void setAdapters(MenuTypeAdapter typeAdapter,MenuDishAdapter dishAdapter){
		this.typeAdapter = typeAdapter;
		this.dishAdapter = dishAdapter;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.menu_fragment, container, false);
		arriveTime = (TextView)view.findViewById(R.id.arriveTime);
		typelist = (ListView)view.findViewById(R.id.typeList);
		dishlist = (ListView)view.findViewById(R.id.dishList);
		titleleft = (TextView)view.findViewById(R.id.title_left_text);
	    titleright = (TextView)view.findViewById(R.id.title_right_text);
	    titlecenter = (TextView)view.findViewById(R.id.title_center_text);
	    titleleft.setText("<");
	    titleleft.setTextColor(Color.WHITE);
	    titleleft.setOnClickListener(this);
	    titlecenter.setText(shopName);
	    titlecenter.setTextColor(Color.WHITE);
	    titleright.setText("");
	    titleleft.setBackgroundColor(defalutColor);
	    titlecenter.setBackgroundColor(defalutColor);
	    titleright.setBackgroundColor(defalutColor);
	    typelist.setOnItemClickListener(this);
	    dishlist.setOnItemClickListener(this);
	    typelist.setAdapter(typeAdapter);
	    dishlist.setAdapter(dishAdapter);
		return view;
	}
	
	public void setShopName(String s){
        shopName = s;
	}
	
	public void setNotiText(String s){
		arriveTime.setText(s);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (OnMenuClickListener)activity;
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.title_left_text:
			listener.onMenuClick(0);
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		if(parent.getId()==R.id.typeList){
			typeAdapter.setSelectIndex(position);
			typeAdapter.notifyDataSetChanged();
		} else {
			Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
		}
	}

}

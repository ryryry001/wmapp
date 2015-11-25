package com.example.wmapp.fragments;

import java.util.ArrayList;

import com.example.wmapp.R;
import com.example.wmapp.adapter.ShopListAdapter;
import com.example.wmapp.data.Shop;
import com.example.wmapp.data.ShopListData;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainShopFragment extends Fragment implements OnClickListener,OnItemClickListener{
	
	private Button classifyButton,sortButton,discountButton;
	private TextView titleleft,titlecenter,titleright;
	private PullToRefreshListView prlist;
	private final int defalutColor = Color.parseColor("#ff7f50");
	private MainShopClickListener listener;
	private ShopListData shopListData;
	private ArrayList<Shop> listData;
	private ShopListAdapter adapter;
	
	public interface MainShopClickListener{
		public void onMainClick(int intent,String shop);
		public void onListItemClick(int shopID,String shopName);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.main_shop_fragment, container, false);
	    classifyButton = (Button)view.findViewById(R.id.choosebarButton1);
	    sortButton = (Button)view.findViewById(R.id.choosebarButton2);
	    discountButton = (Button)view.findViewById(R.id.choosebarButton3);
	    titleleft = (TextView)view.findViewById(R.id.title_left_text);
	    titlecenter = (TextView)view.findViewById(R.id.title_center_text);
	    titleright = (TextView)view.findViewById(R.id.title_right_text);
	    titleleft.setVisibility(View.GONE);
	    titleright.setVisibility(View.GONE);
	    titlecenter.setText("定位地址");
	    titlecenter.setTextColor(Color.WHITE);
	    titlecenter.setBackgroundColor(defalutColor);
	    titlecenter.setOnClickListener(this);
	    classifyButton.setOnClickListener(this);
	    sortButton.setOnClickListener(this);
	    discountButton.setOnClickListener(this);
	    prlist = (PullToRefreshListView)view.findViewById(R.id.prlist);
	    initListData();
	    prlist.setOnItemClickListener(this);
	    return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (MainShopClickListener)activity;
	}
	
	private void initListData(){
		this.shopListData = ShopListData.getInstance();
		this.listData = shopListData.getShopList();
		adapter = new ShopListAdapter(this.listData,getActivity());
		prlist.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.title_center_text:
			listener.onMainClick(0, null);
			break;
		case R.id.choosebarButton1:
			
			break;
		case R.id.choosebarButton2:
			
			break;
		case R.id.choosebarButton3:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		listener.onListItemClick(listData.get(position-1).getShopID(),listData.get(position-1).getName());
	}
}

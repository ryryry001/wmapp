package com.example.wmapp.fragments;

import java.util.ArrayList;

import com.example.wmapp.R;
import com.example.wmapp.adapter.ChooseBarLeftAdapter;
import com.example.wmapp.adapter.ChooseBarRightAdapter;
import com.example.wmapp.adapter.ShopListAdapter;
import com.example.wmapp.data.Shop;
import com.example.wmapp.data.ShopChooseBarData;
import com.example.wmapp.data.ShopListData;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
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
	private LinearLayout chooseLayout;
	private ListView leftList,rightList;
	private TranslateAnimation showAnim,hideAnim,hideshowAnim;
	private int screenWidth,screenHeight;
	private boolean isChooseLayoutShow = false;
	private int showingLayoutIndex = -1;
	private ShopChooseBarData scbData;
	private ChooseBarLeftAdapter leftAdapter;
	private ChooseBarRightAdapter rightAdapter;
	
	public interface MainShopClickListener{
		public void onMainClick(int intent,String shop);
		public void onListItemClick(int shopID,String shopName,int minFee);
	}
	
	public MainShopFragment(int screenHeight, int screenWidth){
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
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
	    chooseLayout = (LinearLayout)view.findViewById(R.id.chooseextendsionLayout);
	    chooseLayout.setOnClickListener(this);
	    leftList = (ListView)view.findViewById(R.id.leftlist);
	    rightList = (ListView)view.findViewById(R.id.rightlist);
	    leftList.setOnItemClickListener(this);
	    rightList.setOnItemClickListener(this);
	    titlecenter.setOnClickListener(this);
	    classifyButton.setOnClickListener(this);
	    sortButton.setOnClickListener(this);
	    discountButton.setOnClickListener(this);
	    prlist = (PullToRefreshListView)view.findViewById(R.id.mainprlist);
	    initListData();
	    prlist.setOnItemClickListener(this);
	    initAnim();
	    initChooseBarData();
	    return view;
	}
	
	private void initChooseBarData(){
		scbData = ShopChooseBarData.getInstance();
		leftAdapter = new ChooseBarLeftAdapter(getActivity(),scbData.getTypeList());
		leftList.setAdapter(leftAdapter);
		rightAdapter = new ChooseBarRightAdapter(getActivity(),null);
		rightList.setAdapter(rightAdapter);
	}
	
	private void initAnim(){
	    if(showAnim == null){
	    	showAnim = new TranslateAnimation(0,0,-screenHeight,0);
	    	showAnim.setDuration(250);
	    }
	    if(hideAnim == null){
	    	hideAnim = new TranslateAnimation(0,0,0,-screenHeight);
	    	hideAnim.setDuration(250);
	    	hideAnim.setAnimationListener(new AnimationListener(){

				@Override
				public void onAnimationStart(Animation animation) {
					
				}

				@Override
				public void onAnimationEnd(Animation animation) {
					chooseLayout.setVisibility(View.GONE);
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					
				}
	    		
	    	});
	    }
	    if(hideshowAnim == null) {
	    	hideshowAnim = new TranslateAnimation(0,0,0,-screenHeight);
	    	hideshowAnim.setDuration(150);
	    	hideshowAnim.setAnimationListener(new AnimationListener(){

				@Override
				public void onAnimationStart(Animation animation) {
					
				}

				@Override
				public void onAnimationEnd(Animation animation) {
					chooseLayout.startAnimation(showAnim);
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					
				}
	    		
	    	});
	    }
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
			//分类菜单
			if(isChooseLayoutShow){
				if(showingLayoutIndex == 1){
					//当前显示的是分类菜单
					chooseLayout.startAnimation(hideAnim);
					isChooseLayoutShow = false;
					showingLayoutIndex = -1;
				} else {
					//当前显示的不是分类菜单
					chooseLayout.startAnimation(hideshowAnim);
					isChooseLayoutShow = true;
					showingLayoutIndex = 1;
				}
			} else {
				//当前未显示菜单
				chooseLayout.setVisibility(View.VISIBLE);
				chooseLayout.startAnimation(showAnim);
				isChooseLayoutShow = true;
				showingLayoutIndex = 1;
			}
			break;
		case R.id.choosebarButton2:
			//筛选菜单
			if(isChooseLayoutShow){
				if(showingLayoutIndex == 2){
					//当前显示的是筛选菜单
					chooseLayout.startAnimation(hideAnim);
					isChooseLayoutShow = false;
					showingLayoutIndex = -1;
				} else {
					//当前显示的不是筛选菜单
					chooseLayout.startAnimation(hideshowAnim);
					isChooseLayoutShow = true;
					showingLayoutIndex = 2;
				}
			} else {
				//当前未显示菜单
				chooseLayout.setVisibility(View.VISIBLE);
				chooseLayout.startAnimation(showAnim);
				isChooseLayoutShow = true;
				showingLayoutIndex = 2;
			}
			break;
		case R.id.choosebarButton3:
			if(isChooseLayoutShow){
				if(showingLayoutIndex == 3){
					//当前显示的是优惠菜单
					chooseLayout.startAnimation(hideAnim);
					isChooseLayoutShow = false;
					showingLayoutIndex = -1;
				} else {
					//当前显示的不是筛选菜单
					chooseLayout.startAnimation(hideshowAnim);
					isChooseLayoutShow = true;
					showingLayoutIndex = 3;
				}
				
			} else {
				//当前未显示菜单
				chooseLayout.setVisibility(View.VISIBLE);
				chooseLayout.startAnimation(showAnim);
				isChooseLayoutShow = true;
				showingLayoutIndex = 3;
			}
			break;
		case R.id.chooseextendsionLayout:
			//hide animation
			chooseLayout.startAnimation(hideAnim);
			isChooseLayoutShow = false;
			showingLayoutIndex = -1;
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		if(parent.getId() == R.id.leftlist) {
			//分类layout左list
			rightAdapter.setList(scbData.getSubList(scbData.getTypeList().get(position)));
			rightAdapter.notifyDataSetChanged();
			leftAdapter.setSelectIndex(position);
			leftAdapter.notifyDataSetChanged();	
		} else if(parent.getId() == R.id.rightlist){
			//分类layout右list
		} else {
			Shop shop = listData.get(position-1);
			listener.onListItemClick(shop.getShopID(),shop.getName(),shop.getMinConsumption());	
		}
		
	}
}

package com.example.wmapp;

import com.example.wmapp.fragments.MainShopFragment;
import com.example.wmapp.fragments.MainShopFragment.MainShopClickListener;
import com.example.wmapp.fragments.TabFragment;
import com.example.wmapp.fragments.TabFragment.TabHandleClickListener;
import com.example.wmapp.fragments.UserInfoFragment;
import com.example.wmapp.fragments.UserInfoFragment.UserInfoHandleClickListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;

public class MainActivity extends FragmentActivity implements UserInfoHandleClickListener,
TabHandleClickListener,MainShopClickListener{
	
    private UserInfoFragment userFrag;
    private MainShopFragment mainFrag;
    private TabFragment tabFrag;
    private FragmentManager fm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_main);
		
		tabFrag = new TabFragment();
		//userFrag = new UserInfoFragment();
		mainFrag = new MainShopFragment();
	    fm = getSupportFragmentManager();
		fm.beginTransaction().add(R.id.main_fragment_container, mainFrag).commit();
		fm.beginTransaction().add(R.id.tab_container,tabFrag).commit();
		
	}

	
	/**
	 * 处理“我的”界面的点击事件
	 */
	@Override
	public void userInfoHandleClick(int intent) {
		switch(intent){
		case 0:
			//跳转到地址管理
			break;
		case 1:
			//跳转到收藏
			break;
		case 2:
			//跳转到帮助
			break;
		case 3:
			//跳转到关于
			break;
		}
	}

	
	/**
	 * 处理tab点击事件
	 */
	@Override
	public void tabHandleClick(int intent) {
		switch(intent){
		case 1:
			tabFrag.setTab(1);
			break;
		case 2:
			tabFrag.setTab(2);
			break;
		case 3:
			tabFrag.setTab(3);
			break;
		}
	}


	/**
	 * 处理主界面（商户界面）的点击事件
	 * @param intent
	 * @param shop
	 */
	@Override
	public void onMainClick(int intent, String shop) {
		switch(intent){
		case 0:
			//选择地址
			break;
		}
	}
	
}

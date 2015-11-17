package com.example.wmapp;

import com.example.wmapp.fragments.TabFragment;
import com.example.wmapp.fragments.TabFragment.TabHandleClickListener;
import com.example.wmapp.fragments.UserInfoFragment;
import com.example.wmapp.fragments.UserInfoFragment.UserInfoHandleClickListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;

public class MainActivity extends FragmentActivity implements UserInfoHandleClickListener,
TabHandleClickListener{
	
    private UserInfoFragment userFrag;
    private TabFragment tabFrag;
    private FragmentManager fm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_login);
		
		tabFrag = new TabFragment();
		userFrag = new UserInfoFragment();
	    fm = getSupportFragmentManager();
		fm.beginTransaction().add(R.id.fragment_container, userFrag).commit();
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
	
}

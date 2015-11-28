package com.example.wmapp;

import com.example.wmapp.fragments.MainShopFragment;
import com.example.wmapp.fragments.MainShopFragment.MainShopClickListener;
import com.example.wmapp.fragments.OrderFragment;
import com.example.wmapp.fragments.TabFragment;
import com.example.wmapp.fragments.TabFragment.TabHandleClickListener;
import com.example.wmapp.fragments.UserInfoFragment;
import com.example.wmapp.fragments.UserInfoFragment.UserInfoHandleClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements UserInfoHandleClickListener,
TabHandleClickListener,MainShopClickListener{
	
    private UserInfoFragment userFrag;
    private MainShopFragment mainFrag;
    private OrderFragment orderFrag;
    private TabFragment tabFrag;
    private FragmentManager fm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_main);
		
		tabFrag = new TabFragment();
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
		    Log.v("mytag","1");
			Intent intent2 = new Intent(MainActivity.this,MapActivity.class);
			
			int requestCode = 1;  
            startActivityForResult(intent2, requestCode);  
			break;
		case 1:
			//跳转到收藏
			 Log.v("mytag","2");
			break;
		case 2:
			 Log.v("mytag","3");
			//跳转到帮助
			break;
		case 3:
			 Log.v("mytag","4");
			//跳转到关于
			break;
		}
	}

	    @Override  
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        String address = data.getStringExtra("address");  
	        
	        // 根据上面发送过去的请求吗来区别  
	        switch (requestCode) {  
	        case 1:  
	            Log.v("mytag", address);
	            break;  
	       
	        default:  
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
			if(mainFrag == null){
				mainFrag = new MainShopFragment();
			}
			fm.beginTransaction().replace(R.id.main_fragment_container, mainFrag).commit();
			break;
		case 2:
			tabFrag.setTab(2);
			if(orderFrag == null){
				orderFrag = new OrderFragment();
			}
			fm.beginTransaction().replace(R.id.main_fragment_container, orderFrag).commit();
			break;
		case 3:
			tabFrag.setTab(3);
			if(userFrag == null){
				userFrag = new UserInfoFragment();
			}
			fm.beginTransaction().replace(R.id.main_fragment_container, userFrag).commit();
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
		Log.v("mytag","mytag"+"wsmmyshuchu");
		switch(intent){
		case 0:
			//选择地址
			Log.v("mytag","mytag"+"wsmmyshuchu");
			break;
		}
	}

	/**
	 * 主界面listitem点击事件处理
	 * @param shopID 商户id
	 */
	@Override
	public void onListItemClick(int shopID,String shopName,int minFee) {
		Intent intent = new Intent(MainActivity.this,ShopDetailActivity.class);
		intent.putExtra("shopID", shopID);
		intent.putExtra("shopName", shopName);
		intent.putExtra("min", minFee);
		startActivity(intent);
	}
	
}

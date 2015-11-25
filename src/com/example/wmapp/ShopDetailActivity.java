package com.example.wmapp;

import java.util.ArrayList;

import com.example.wmapp.adapter.MenuDishAdapter;
import com.example.wmapp.adapter.MenuTypeAdapter;
import com.example.wmapp.data.Dish;
import com.example.wmapp.fragments.MenuFragment;
import com.example.wmapp.fragments.MenuFragment.OnMenuClickListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;

public class ShopDetailActivity extends FragmentActivity implements OnMenuClickListener{

    private FragmentManager fm;
    private MenuFragment menuFrag;
    private int shopID;
    private String shopName;
    private MenuTypeAdapter typeAdapter;
    private MenuDishAdapter dishAdapter;
    private ArrayList<String> typeList;
    private ArrayList<Dish> dishList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_shop_detail);
		
		shopID = getIntent().getIntExtra("shopID", 0);
		shopName = getIntent().getStringExtra("shopName");
		
		typeList = new ArrayList<String>();
		dishList = new ArrayList<Dish>();
		//test data
		typeList.add("粥类");
		typeList.add("饼类");
		typeList.add("面条");
		typeList.add("汤类");
		dishList.add(new Dish("皮蛋瘦肉粥",null,12038,4.0f,12.00f));
		dishList.add(new Dish("皮蛋瘦肉粥",null,12038,4.0f,12.00f));
		dishList.add(new Dish("皮蛋瘦肉粥",null,12038,4.0f,12.00f));
		dishList.add(new Dish("皮蛋瘦肉粥",null,12038,4.0f,12.00f));
		dishList.add(new Dish("皮蛋瘦肉粥",null,12038,4.0f,12.00f));
		dishList.add(new Dish("皮蛋瘦肉粥",null,12038,4.0f,12.00f));
		dishList.add(new Dish("皮蛋瘦肉粥",null,12038,4.0f,12.00f));
		//test data end
		typeAdapter = new MenuTypeAdapter(this,typeList);
		dishAdapter = new MenuDishAdapter(this,dishList);
		
		menuFrag = new MenuFragment();
		menuFrag.setShopName(shopName);
		menuFrag.setAdapters(typeAdapter, dishAdapter);
	    fm = getSupportFragmentManager();
		fm.beginTransaction().add(R.id.menu_container, menuFrag).commit();
		//fm.beginTransaction().add(R.id.cart_container,tabFrag).commit();
	}
	
	@Override
	public void onMenuClick(int intent) {
		// TODO Auto-generated method stub
		switch(intent){
		case 0:
			finish();
			break;
		}
	}

}

package com.example.wmapp;

import java.util.ArrayList;

import com.example.wmapp.adapter.MenuDishAdapter;
import com.example.wmapp.adapter.MenuDishAdapter.AddOrderItemListener;
import com.example.wmapp.adapter.MenuTypeAdapter;
import com.example.wmapp.data.Dish;
import com.example.wmapp.data.OrderItem;
import com.example.wmapp.fragments.CartFragment;
import com.example.wmapp.fragments.CartFragment.cartClickListener;
import com.example.wmapp.fragments.MenuFragment;
import com.example.wmapp.fragments.MenuFragment.OnMenuClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;
import android.widget.Toast;

public class ShopDetailActivity extends FragmentActivity implements OnMenuClickListener,
    AddOrderItemListener,cartClickListener{

    private FragmentManager fm;
    private MenuFragment menuFrag;
    private CartFragment cartFrag;
    private int shopID;
    private String shopName;
    private MenuTypeAdapter typeAdapter;
    private MenuDishAdapter dishAdapter;
    //餐厅菜单分类列表
    private ArrayList<String> typeList;
    //餐厅菜品列表
    private ArrayList<Dish> dishList;
    //已点菜品列表
    private ArrayList<OrderItem> orderList;
    //最低消费
    private int min = 0;
    private int total = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_shop_detail);
		
		Intent intent = getIntent();
		shopID = intent.getIntExtra("shopID", 0);
		shopName = intent.getStringExtra("shopName");
		min = intent.getIntExtra("min", 0);
		
		orderList = new ArrayList<OrderItem>();
		
		typeList = new ArrayList<String>();
		dishList = new ArrayList<Dish>();
		//test data
		typeList.add("粥类");
		typeList.add("饼类");
		typeList.add("面条");
		typeList.add("汤类");
		dishList.add(new Dish("皮蛋瘦肉粥",null,12038,4.0f,12.00f));
		dishList.add(new Dish("黑米粥",null,12039,4.0f,12.00f));
		dishList.add(new Dish("红豆粥",null,12037,4.0f,12.00f));
		dishList.add(new Dish("滑蛋牛肉粥",null,12028,4.0f,12.00f));
		dishList.add(new Dish("鲜虾粥",null,12078,4.0f,12.00f));
		//test data end
		typeAdapter = new MenuTypeAdapter(this,typeList);
		dishAdapter = new MenuDishAdapter(this,dishList,(AddOrderItemListener)this);
		
		menuFrag = new MenuFragment();
		cartFrag = new CartFragment();
		cartFrag.setMinFee(min);
		menuFrag.setShopName(shopName);
		menuFrag.setAdapters(typeAdapter, dishAdapter);
	    fm = getSupportFragmentManager();
		fm.beginTransaction().add(R.id.menu_container, menuFrag).commit();
		fm.beginTransaction().add(R.id.cart_container,cartFrag).commit();
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

	@Override
	public void addItem(String name,int dishID,float price) {
		for(OrderItem item:orderList){
			if(item.getName().equals(name)&&(item.getDishID() == dishID)){
				item.setNum(item.getNum()+1);
				total+=price;
				if(total>=min){
					cartFrag.setCanSendFlag(true,0);
				} else {
					cartFrag.setCanSendFlag(false, min-total);
				}
				cartFrag.setTotalPrice(total);
				return;
			}
		}
		orderList.add(new OrderItem(name,dishID,1,price));
		total+=price;
		if(total>=min){
			cartFrag.setCanSendFlag(true,0);
		} else {
			cartFrag.setCanSendFlag(false, min-total);
		}
		cartFrag.setTotalPrice(total);
	}

	@Override
	public void deleteItem(String name, int dishID) {
		// TODO Auto-generated method stub
		for(OrderItem item:orderList){
			if(item.getName().equals(name) && (item.getDishID() == dishID)){
				if(item.getNum() == 1){
					orderList.remove(item);
				} else {
					item.setNum(item.getNum()-1);
				}
				total-=item.getPrice();
				if(total<min){
					cartFrag.setCanSendFlag(false,min - total);
				}
				cartFrag.setTotalPrice(total);
				break;
			}
		}
	}

	@Override
	public void setAnimationLocation(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 提交订单
	 */
	@Override
	public void sendOrder() {
		// TODO Auto-generated method stub
		Toast.makeText(ShopDetailActivity.this, "下单", Toast.LENGTH_SHORT).show();
	}

}

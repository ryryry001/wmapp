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
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
    //动画的起使坐标
    private int cartLocationX;
    private int cartLocationY;
    private int viewX;
    private int viewY;
    
    private ViewGroup anim_mask_layout;
    private ImageView buyImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_shop_detail);
		
		buyImage = new ImageView(this);// buyImg是动画的图片，我的是一个小球（R.drawable.sign）
		buyImage.setImageResource(R.drawable.sign);// 设置buyImg的图片
		
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
		if(cartLocationX == 0 && cartLocationY == 0){
			cartFrag.measureCartLocation();
		}
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
				setAnim(buyImage);
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
		setAnim(buyImage);
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
	
	private void setViewOnAnimLayout(final ViewGroup vg, final View view,
			int startX, int startY) {
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		lp.leftMargin = startX;
		lp.topMargin = startY;
		view.setLayoutParams(lp);
	}
	
	private void setAnim(final View v) {

		if(anim_mask_layout == null){
			anim_mask_layout = createAnimLayout();	
			anim_mask_layout.addView(buyImage);//把动画小球添加到动画层
		}
		setViewOnAnimLayout(anim_mask_layout, buyImage,
				viewX,viewY);
		// 计算位移
		int endX = cartLocationX - viewX;// 动画位移的X坐标
		int endY = cartLocationY - viewY;// 动画位移的y坐标
		TranslateAnimation translateAnimationX = new TranslateAnimation(0,
				endX, 0, 0);
		translateAnimationX.setInterpolator(new LinearInterpolator());
		translateAnimationX.setRepeatCount(0);// 动画重复执行的次数
		translateAnimationX.setFillAfter(true);

		TranslateAnimation translateAnimationY = new TranslateAnimation(0, 0,
				0, endY);
		translateAnimationY.setInterpolator(new AccelerateInterpolator());
		translateAnimationY.setRepeatCount(0);// 动画重复执行的次数
		translateAnimationX.setFillAfter(true);

		AnimationSet set = new AnimationSet(false);
		set.setFillAfter(false);
		set.addAnimation(translateAnimationY);
		set.addAnimation(translateAnimationX);
		set.setDuration(400);// 动画的执行时间
		v.startAnimation(set);
		// 动画监听事件
		set.setAnimationListener(new AnimationListener() {
			// 动画的开始
			@Override
			public void onAnimationStart(Animation animation) {
				v.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}

			// 动画的结束
			@Override
			public void onAnimationEnd(Animation animation) {
				v.setVisibility(View.GONE);
			}
		});

	}

	private ViewGroup createAnimLayout() {
		ViewGroup rootView = (ViewGroup) this.getWindow().getDecorView();
		LinearLayout animLayout = new LinearLayout(this);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);
		animLayout.setLayoutParams(lp);
		animLayout.setId(Integer.MAX_VALUE);
		animLayout.setBackgroundResource(android.R.color.transparent);
		rootView.addView(animLayout);
		return animLayout;
	}
	
	
	/**
	 * 提交订单
	 */
	@Override
	public void sendOrder() {
		// TODO Auto-generated method stub
		Toast.makeText(ShopDetailActivity.this, "下单", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setCartLocation(int x, int y) {
		cartLocationX = x;
		cartLocationY = y;
	}

	@Override
	public void setViewLocation(int x, int y) {
		this.viewX = x;
		this.viewY = y;
	}


}

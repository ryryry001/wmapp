package com.example.wmapp.fragments;

import com.example.wmapp.R;
import com.example.wmapp.fragments.UserInfoFragment.UserInfoHandleClickListener;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CartFragment extends Fragment implements OnClickListener{

	private ImageView cartImage;
	private TextView priceText;
	private TextView rbText;
	private TextView totalNumText;
	private cartClickListener listener;
	private int defaultColor = Color.parseColor("#ff7f50");
	private int grayColor = Color.parseColor("#cccccc");
	private int min;
	private boolean canSendOrder = false;
	
	public interface cartClickListener{
	    public void sendOrder();	
	    public void setCartLocation(int x, int y);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.cart_bottom_bar, container, false);
		cartImage = (ImageView)view.findViewById(R.id.cartImage);
		priceText = (TextView)view.findViewById(R.id.price);
		rbText = (TextView)view.findViewById(R.id.rbtext);
		totalNumText = (TextView)view.findViewById(R.id.totalNum);
		totalNumText.setVisibility(View.GONE);
		rbText.setText("还差¥"+min+"起送");
		rbText.setOnClickListener(this);
		return view;
	}
	
	public void setTotalNum(int totalNum){
		if(totalNum <= 0){
			totalNumText.setVisibility(View.GONE);
		} else {
			totalNumText.setText(String.valueOf(totalNum));
			totalNumText.setVisibility(View.VISIBLE);	
		}
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (cartClickListener)activity;
	}
	
	public void setMinFee(int min){
		this.min = min;
	}
	
	public void measureCartLocation(){
		int[] location = new int[2];
		cartImage.getLocationInWindow(location);
		listener.setCartLocation(location[0],location[1]);
	}
	
	public void setCanSendFlag(boolean b,float delta){
		this.canSendOrder = b;
		if(canSendOrder){
			rbText.setText("去结算");
			rbText.setTextColor(Color.WHITE);
			rbText.setBackgroundColor(defaultColor);
		} else {
			rbText.setText("还差¥"+delta+"起送");
			rbText.setBackgroundColor(Color.TRANSPARENT);
			rbText.setTextColor(grayColor);
		}
	}
	
	public void setTotalPrice(float price){
		priceText.setText(price+"");
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.rbtext){
			if(canSendOrder){
				listener.sendOrder();
			}
		}
	}
}

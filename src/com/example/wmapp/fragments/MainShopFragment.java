package com.example.wmapp.fragments;

import com.example.wmapp.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainShopFragment extends Fragment{
	
	private ImageView mainImageView;
	private Button classifyButton,sortButton,discountButton;
	private TextView titleleft,titlecenter,titleright;
	private PullToRefreshListView prlist;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.main_shop_fragment, container, false);
	    mainImageView = (ImageView)view.findViewById(R.id.mainpageImage);
	    classifyButton = (Button)view.findViewById(R.id.choosebarButton1);
	    sortButton = (Button)view.findViewById(R.id.choosebarButton2);
	    discountButton = (Button)view.findViewById(R.id.choosebarButton3);
	    titleleft = (TextView)view.findViewById(R.id.title_left_text);
	    titlecenter = (TextView)view.findViewById(R.id.title_center_text);
	    titleright = (TextView)view.findViewById(R.id.title_right_text);
	    titleleft.setVisibility(View.GONE);
	    titleright.setVisibility(View.GONE);
	    titlecenter.setText("定位地址");
	    prlist = (PullToRefreshListView)view.findViewById(R.id.prlist);
	    return view;
	}
}

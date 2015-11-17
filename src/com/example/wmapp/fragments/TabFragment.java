package com.example.wmapp.fragments;

import com.example.wmapp.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TabFragment extends Fragment implements OnClickListener{
	
	private TabHandleClickListener listener;
	private TextView tab1Text,tab2Text,tab3Text;
    private ImageView tab1Image,tab2Image,tab3Image;
    private LinearLayout tab1,tab2,tab3;
    private int choosedColor = Color.parseColor("#ff7f50");
    private int defaultColor = Color.parseColor("#cccccc");
	
	public interface TabHandleClickListener{
		public void tabHandleClick(int intent);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tab, container, false);
		tab1 = (LinearLayout)view.findViewById(R.id.tab1);
		tab2 = (LinearLayout)view.findViewById(R.id.tab2);
		tab3 = (LinearLayout)view.findViewById(R.id.tab3);
		tab1Text = (TextView)view.findViewById(R.id.tab1Text);
		tab2Text = (TextView)view.findViewById(R.id.tab2Text);
		tab3Text = (TextView)view.findViewById(R.id.tab3Text);
		tab1Image = (ImageView)view.findViewById(R.id.tab1Image);
		tab2Image = (ImageView)view.findViewById(R.id.tab2Image);
		tab3Image = (ImageView)view.findViewById(R.id.tab3Image);
		tab1.setOnClickListener(this);
		tab2.setOnClickListener(this);
		tab3.setOnClickListener(this);
		return view;
	}
	
	public void setTab(int index){
		switch(index){
		case 1:
			tab1Text.setTextColor(choosedColor);
			tab2Text.setTextColor(defaultColor);
			tab3Text.setTextColor(defaultColor);
			break;
		case 2:
			tab2Text.setTextColor(choosedColor);
			tab1Text.setTextColor(defaultColor);
			tab3Text.setTextColor(defaultColor);
			break;
		case 3:
			tab3Text.setTextColor(choosedColor);
			tab2Text.setTextColor(defaultColor);
			tab1Text.setTextColor(defaultColor);
			break;
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (TabHandleClickListener)activity;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.tab1:
		//case R.id.tab1Image:
		//case R.id.tab1Text:
			listener.tabHandleClick(1);
			break;
		case R.id.tab2:
		//case R.id.tab2Image:
		//case R.id.tab2Text:
			listener.tabHandleClick(2);
			break;
		case R.id.tab3:
		//case R.id.tab3Image:
		//case R.id.tab3Text:
			listener.tabHandleClick(3);
			break;
		}
	}

}

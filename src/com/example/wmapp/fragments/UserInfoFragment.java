package com.example.wmapp.fragments;

import com.example.wmapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserInfoFragment extends Fragment implements OnClickListener{
	
	private UserInfoHandleClickListener listener;
	private LinearLayout addLayout;
	private LinearLayout collectionLayout;
	private LinearLayout helpLayout;
	private LinearLayout aboutLayout;
	private ImageView avatorImage;
	private TextView usernameText;
	
	public interface UserInfoHandleClickListener{
		public void userInfoHandleClick(int intent);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.userinfo_fragment, container, false);
		addLayout = (LinearLayout)view.findViewById(R.id.userinfoaddresslayout);
		collectionLayout = (LinearLayout)view.findViewById(R.id.userinfocollectionlayout);
		helpLayout = (LinearLayout)view.findViewById(R.id.userinfohelplayout);
		aboutLayout = (LinearLayout)view.findViewById(R.id.userinfoaboutlayout);
		avatorImage = (ImageView)view.findViewById(R.id.avatorImage);
		usernameText = (TextView)view.findViewById(R.id.nicknameText);
		addLayout.setOnClickListener(this);
		collectionLayout.setOnClickListener(this);
		helpLayout.setOnClickListener(this);
		aboutLayout.setOnClickListener(this);
		
		
		
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (UserInfoHandleClickListener)activity;
		
	}

	@Override
	public void onClick(View v) {
		
		
		
		
		switch(v.getId()){
		case R.id.userinfoaddresslayout:
			listener.userInfoHandleClick(0);
			break;
		case R.id.userinfocollectionlayout:
			listener.userInfoHandleClick(1);
		    break;
		case R.id.userinfohelplayout:
			listener.userInfoHandleClick(2);
			break;
		case R.id.userinfoaboutlayout:
			listener.userInfoHandleClick(3);
			break;
		}
	}
}

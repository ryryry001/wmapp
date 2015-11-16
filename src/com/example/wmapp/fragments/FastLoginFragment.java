package com.example.wmapp.fragments;

import com.example.wmapp.R;
import com.example.wmapp.fragments.ForgetPasswordFragment.forgetHandleClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FastLoginFragment extends Fragment implements OnClickListener{
	
	private TextView titleleft;
	private TextView titleright;
	private TextView titlecenter;
	private Button fastloginButton;
	private Button fastloginCAPTCHAButton;
	private EditText fastloginphoneEdit;
	private EditText fastloginCAPTCHAEdit;
	private FastLoginHandleClickListner listener;
	
	public interface FastLoginHandleClickListner{
		public void fastloginHandleClick(int intent);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.fastlogin_fragment, container, false);
	    titleleft = (TextView)view.findViewById(R.id.title_left_text);
	    titleright = (TextView)view.findViewById(R.id.title_right_text);
	    titlecenter = (TextView)view.findViewById(R.id.title_center_text);
	    fastloginButton = (Button)view.findViewById(R.id.fastloginButton);
	    fastloginCAPTCHAButton = (Button)view.findViewById(R.id.fastloginCAPTCHAButton);
	    fastloginphoneEdit = (EditText)view.findViewById(R.id.fastloginphoneEdit);
	    fastloginCAPTCHAEdit = (EditText)view.findViewById(R.id.fastloginCAPTCHAEdit);
	    initTitleBar();
	    fastloginButton.setOnClickListener(this);
	    fastloginCAPTCHAButton.setOnClickListener(this);
	    titleleft.setOnClickListener(this);
	    return view;
	}
	
	private void initTitleBar(){
		titleleft.setText("<");
		titlecenter.setText("快捷登陆");
		titleright.setText("");
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (FastLoginHandleClickListner)activity;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.title_left_text:
			listener.fastloginHandleClick(0);
			break;
		case R.id.fastloginButton:
			listener.fastloginHandleClick(1);
			break;
		case R.id.fastloginCAPTCHAButton:
			listener.fastloginHandleClick(2);
			break;
		}
		
	}

}

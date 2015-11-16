package com.example.wmapp.fragments;

import com.example.wmapp.R;

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

public class LoginFragment extends Fragment implements OnClickListener{
	
	private Button loginButton;
	private EditText phoneEdit;
	private EditText passwordEdit;
	private TextView registerText;
	private TextView closeText;
	private TextView forgetpasswordText;
	private TextView fastloginText;
	
	private HandleLoginClickListener listener;
	
	public interface HandleLoginClickListener {
		public void onHandleClick(int intent);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.login_fragment, container, false);
		loginButton = (Button)view.findViewById(R.id.loginButton);
		phoneEdit = (EditText)view.findViewById(R.id.loginphoneEdit);
		passwordEdit = (EditText)view.findViewById(R.id.loginpasswordEdit);
		registerText = (TextView)view.findViewById(R.id.title_right_text);
		closeText = (TextView)view.findViewById(R.id.title_left_text);
		forgetpasswordText = (TextView)view.findViewById(R.id.forgetpasswordText);
		fastloginText = (TextView)view.findViewById(R.id.fastloginText);
		loginButton.setOnClickListener(this);
		registerText.setOnClickListener(this);
		closeText.setOnClickListener(this);
		forgetpasswordText.setOnClickListener(this);
		fastloginText.setOnClickListener(this);
		return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (HandleLoginClickListener)activity;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.loginButton:
			listener.onHandleClick(0);
			break;
		case R.id.title_left_text:
			listener.onHandleClick(1);
			break;
		case R.id.title_right_text:
			listener.onHandleClick(2);
			break;
		case R.id.forgetpasswordText:
			listener.onHandleClick(3);
			break;
		case R.id.fastloginText:
			listener.onHandleClick(4);
			break;
		}
	}

}

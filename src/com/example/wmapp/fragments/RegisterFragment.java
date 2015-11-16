package com.example.wmapp.fragments;

import com.example.wmapp.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterFragment extends Fragment implements OnClickListener{
	
	private TextView step1Text,step2Text,step3Text;
	private TextView titleleft,titlecenter,titleright;
	private EditText registEdit;
	private Button registButton;
	private int registStep = 1;
	private RegistHandleClickListener listener;
	private final int currentColor = Color.parseColor("#ff7f50");
	private final int defaultColor = Color.parseColor("#ffffff");
	
	public interface RegistHandleClickListener{
		public void registHandleClick(int type, int step, String info);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.register_fragment, container, false);
		step1Text = (TextView)view.findViewById(R.id.registStep1Text);
		step2Text = (TextView)view.findViewById(R.id.registStep2Text);
		step3Text = (TextView)view.findViewById(R.id.registStep3Text);
		titleleft = (TextView)view.findViewById(R.id.title_left_text);
		titlecenter = (TextView)view.findViewById(R.id.title_center_text);
		titleright = (TextView)view.findViewById(R.id.title_right_text);
		registButton = (Button)view.findViewById(R.id.registerButton);
		registEdit = (EditText)view.findViewById(R.id.registerEdit);
		initTitleBar();
		initStep1();
		titleleft.setOnClickListener(this);
		registButton.setOnClickListener(this);
		return view;
	}
	
	private void initTitleBar(){
		titleright.setText("");
		titlecenter.setText("注册");
		titleleft.setText("<");
	}
	
	private void initStep1(){
		step1Text.setTextColor(currentColor);
		step2Text.setTextColor(defaultColor);
		step3Text.setTextColor(defaultColor);
		registButton.setText("获取验证码");
		registEdit.setText("");
		registEdit.setHint("    请输入手机号");
	}
	
	private void initStep2(){
		step1Text.setTextColor(defaultColor);
		step2Text.setTextColor(currentColor);
		step3Text.setTextColor(defaultColor);
		registButton.setText("提交验证码");
		registEdit.setText("");
		registEdit.setHint("    请输入验证码");
	}
	
	private void initStep3(){
		step1Text.setTextColor(defaultColor);
		step2Text.setTextColor(defaultColor);
		step3Text.setTextColor(currentColor);
		registButton.setText("确定");
		registEdit.setText("");
		registEdit.setHint("    请输入密码");
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (RegistHandleClickListener)activity;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.registerButton:
			if(registStep == 1){
				listener.registHandleClick(0, 1, registEdit.getText().toString());
				registStep = 2;
				initStep2();
			} else if(registStep == 2) {
				listener.registHandleClick(0, 2, registEdit.getText().toString());
				registStep = 3;
				initStep3();
			} else if(registStep == 3) {
				listener.registHandleClick(0, 3, registEdit.getText().toString());
			}
			break;
		case R.id.title_left_text:
            if(registStep == 1){
				listener.registHandleClick(1, 1, null);
			} else if(registStep == 2) {
				registStep = 1;
				initStep1();
				listener.registHandleClick(1, 2, null);
			}
			break;
		}
	}
	
	public void setCachedPhone(String phone){
		if(registStep == 1){
			registEdit.setText(phone);
		}
	}

}

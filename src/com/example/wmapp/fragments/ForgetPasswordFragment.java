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

public class ForgetPasswordFragment extends Fragment implements OnClickListener{
	
	private forgetHandleClickListener listener;
	private TextView titleleft,titlecenter,titleright;
	private EditText forgetphoneEdit,forgetCAPTCHAEdit,forgetPasswordEdit,forgetcomfirmEdit;
	private Button forgetfinishButton,forgetphoneButton;
	
	public interface forgetHandleClickListener{
		public void forgetHandleClick(int intent);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.forgetpassword_fragment, container, false);
		forgetphoneEdit = (EditText)view.findViewById(R.id.forgetpasswordphoneEdit);
		forgetCAPTCHAEdit = (EditText)view.findViewById(R.id.forgetpasswordCAPTCHAEdit);
		forgetPasswordEdit = (EditText)view.findViewById(R.id.forgetpasswordPassordEdit);
		forgetcomfirmEdit = (EditText)view.findViewById(R.id.forgetpasswordcomfirmpassordEdit);
		forgetfinishButton = (Button)view.findViewById(R.id.forgetpasswordfinishButton);
		forgetphoneButton = (Button)view.findViewById(R.id.forgetpasswordphoneButton);
		titleleft = (TextView)view.findViewById(R.id.title_left_text);
		titleright = (TextView)view.findViewById(R.id.title_right_text);
		titlecenter = (TextView)view.findViewById(R.id.title_center_text);
		initTitleBar();
		titleleft.setOnClickListener(this);
		forgetfinishButton.setOnClickListener(this);
		forgetphoneButton.setOnClickListener(this);
		return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener = (forgetHandleClickListener)activity;
	}

	private void initTitleBar(){
		titlecenter.setText("忘记密码");
		titleleft.setText("<");
		titleright.setText("");
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.forgetpasswordphoneButton:
			//获取验证码
			listener.forgetHandleClick(0);
			break;
		case R.id.forgetpasswordfinishButton:
			//完成按钮
			listener.forgetHandleClick(1);
			break;
		case R.id.title_left_text:
			//返回登陆界面
			listener.forgetHandleClick(2);
			break;
		}
	}
}

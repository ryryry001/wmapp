package com.example.wmapp;

import com.example.wmapp.fragments.ForgetPasswordFragment;
import com.example.wmapp.fragments.ForgetPasswordFragment.forgetHandleClickListener;
import com.example.wmapp.fragments.LoginFragment;
import com.example.wmapp.fragments.LoginFragment.HandleLoginClickListener;
import com.example.wmapp.fragments.RegisterFragment;
import com.example.wmapp.fragments.RegisterFragment.RegistHandleClickListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Window;
import android.widget.Toast;

public class LoginActivity extends FragmentActivity implements HandleLoginClickListener,
RegistHandleClickListener,forgetHandleClickListener{
	
	private LoginFragment loginFrag;
	private RegisterFragment registFrag;
	private ForgetPasswordFragment forgetFrag;
    private String username,password;
    private FragmentManager fm;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_login);
		
	    loginFrag = new LoginFragment();
	    fm = getSupportFragmentManager();
		fm.beginTransaction().add(R.id.fragment_container, loginFrag).commit();
	}

	/**
	 * 处理登陆界面的点击事件
	 */
	@Override
	public void onHandleClick(int intent) {
		switch(intent){
		case 0:
			//login
			Toast.makeText(LoginActivity.this, "login", Toast.LENGTH_SHORT).show();
			break;
		case 1:
			//close
			finish();
			break;
		case 2:
			//toRegister
			if(registFrag == null){
				registFrag = new RegisterFragment();
			}
			fm.beginTransaction().replace(R.id.fragment_container, registFrag).commit();
			break;
		case 3:
			//toForegetPassword
			if(forgetFrag == null){
				forgetFrag = new ForgetPasswordFragment();
			}
			fm.beginTransaction().replace(R.id.fragment_container, forgetFrag).commit();
			break;
		case 4:
			//toFastLogin
			Toast.makeText(LoginActivity.this, "fastlogin", Toast.LENGTH_SHORT).show();
			break;
		}
	}

	/**
	 * 处理注册界面的点击事件
	 */
	@Override
	public void registHandleClick(int type, int step, String info) {
		if(type == 0){
			//forward
			switch(step){
			case 1:
				//记录username
				username = info;
				break;
			case 2:
				//验证码校验
				break;
			case 3:
				//记录密码
				password = info;
				break;
			}
		} else {
			//backward
			switch(step){
			case 1:
				//放弃注册，退回到登录界面
				if(loginFrag == null){
					loginFrag = new LoginFragment();
				}
				fm.beginTransaction().replace(R.id.fragment_container, loginFrag).commit();
				break;
			case 2:
				//退回到第一步修改手机号
				registFrag.setCachedPhone(username);
				break;
			case 3:
				//退回到第二步，应该禁止这种操作
				break;
			}
		}
	}

	/**
	 * 处理忘记密码界面的点击事件
	 */
	@Override
	public void forgetHandleClick(int intent) {
		switch(intent){
		case 0:
			//获取验证码
			break;
		case 1:
			//完成修改
			//进入登陆界面
			break;
		case 2:
			//返回登陆界面
			if(loginFrag == null){
				loginFrag = new LoginFragment();
			}
			fm.beginTransaction().replace(R.id.fragment_container, loginFrag).commit();
			break;
		}
	}

}

package com.example.wmapp;

import com.example.wmapp.fragments.LoginFragment;
import com.example.wmapp.fragments.LoginFragment.HandleClickListener;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.Toast;

public class LoginActivity extends FragmentActivity implements HandleClickListener{
	
	LoginFragment loginFrag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_login);
		
	    loginFrag = new LoginFragment();
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, loginFrag).commit();
	}

	@Override
	public void onHandleClick(int intent) {
		switch(intent){
		case 0:
			//login
			Toast.makeText(LoginActivity.this, "login", Toast.LENGTH_SHORT).show();
			break;
		case 1:
			//close
			Toast.makeText(LoginActivity.this, "close", Toast.LENGTH_SHORT).show();
			break;
		case 2:
			//toRegister
			Toast.makeText(LoginActivity.this, "register", Toast.LENGTH_SHORT).show();
			break;
		case 3:
			//toForegetPassword
			Toast.makeText(LoginActivity.this, "forget", Toast.LENGTH_SHORT).show();
			break;
		case 4:
			//toFastLogin
			Toast.makeText(LoginActivity.this, "fastlogin", Toast.LENGTH_SHORT).show();
			break;
		}
	}

}

package com.example.wmapp;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class App extends Application {

	public static RequestQueue requestQueue;
	 
	@Override  
	public void onCreate() {
        super.onCreate();
	    requestQueue = Volley.newRequestQueue(this);
	}
	
	public RequestQueue getRequestQueue(){
		return this.requestQueue;
	}
}

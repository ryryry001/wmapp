package com.example.wmapp.view;

import com.nineoldandroids.view.ViewHelper;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {
	
	private ViewGroup wrapper;
	private ImageView mainImage;
	private ViewGroup chooseBar;
	private ViewGroup prlistLayout;
	private int screenHeight;
	private int mainImageHeight;
	private int chooseBarHeight;
	private boolean once;

	public CustomScrollView(Context context) {
		super(context);
	}
	
	public CustomScrollView(Context context, AttributeSet attrs){
		super(context, attrs);
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
	    DisplayMetrics outMetrics = new DisplayMetrics();
	    wm.getDefaultDisplay().getMetrics(outMetrics);
	    screenHeight = outMetrics.heightPixels;
	    mainImageHeight = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90, context.getResources().getDisplayMetrics());
        chooseBarHeight = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, context.getResources().getDisplayMetrics());
	}
	
	public CustomScrollView(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		if(!once){
			wrapper = (LinearLayout)getChildAt(0);
			mainImage = (ImageView)wrapper.getChildAt(0);
			chooseBar = (ViewGroup)wrapper.getChildAt(1);
			prlistLayout = (ViewGroup)wrapper.getChildAt(2);
			prlistLayout.getLayoutParams().height = screenHeight - chooseBarHeight*3;
			mainImage.getLayoutParams().height = mainImageHeight;
			chooseBar.getLayoutParams().height = chooseBarHeight;
			once = true;
		}
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev){
		if(getScrollY()>=mainImageHeight){
			return false;
		} else {
			return super.onInterceptTouchEvent(ev);
		}
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt){
		super.onScrollChanged(l, t, oldl, oldt);
		if(t>=mainImageHeight){
			ViewHelper.setTranslationY(chooseBar, t-mainImageHeight);
		}
		
	}

}

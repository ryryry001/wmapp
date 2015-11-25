package com.example.wmapp.fragments;

import java.util.ArrayList;

import com.example.wmapp.R;
import com.example.wmapp.adapter.OrderListAdapter;
import com.example.wmapp.data.DBManager;
import com.example.wmapp.data.Order;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class OrderFragment extends Fragment implements OnItemClickListener{
	
	private TextView titlecenter;
	private TextView titleleft;
	private TextView titleright;
	private PullToRefreshListView prlist;
	private final int defalutColor = Color.parseColor("#ff7f50");
	private ArrayList<Order> orders;
	private OrderListAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.order_list, container, false);
	    titleleft = (TextView)view.findViewById(R.id.title_left_text);
	    titlecenter = (TextView)view.findViewById(R.id.title_center_text);
	    titleright = (TextView)view.findViewById(R.id.title_right_text);
	    titleleft.setVisibility(View.GONE);
	    titleright.setVisibility(View.GONE);
	    titlecenter.setText("订单");
	    titlecenter.setTextColor(Color.WHITE);
	    titlecenter.setBackgroundColor(defalutColor);
	    prlist = (PullToRefreshListView)view.findViewById(R.id.orderlist);
	    initListData();
	    prlist.setOnItemClickListener(this);
	    return view;
	}
	
	private void initListData(){
//		DBManager dbm = new DBManager(getActivity());
//		orders = (ArrayList<Order>) dbm.queryAllOrder();
//		dbm.closeDB();
		//订单测试数据
		orders = new ArrayList<Order>();
		orders.add(new Order("109288",""+(System.currentTimeMillis()-1000000),"已送达","桃园食堂","83429","34","-1"));
		orders.add(new Order("1092188",""+(System.currentTimeMillis()),"卖力送单中","梅园食堂","831429","32","17"));
		//订单测试数据结束
		adapter = new OrderListAdapter(getActivity(),orders);
		prlist.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), orders.get(position-1).getShopName(), Toast.LENGTH_SHORT).show();
	}
	
}

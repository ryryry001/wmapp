package com.example.wmapp.data;
/*
 * 封装了  person 用户表           的增删改查接口
 * 
 * 封装了 ord_list  订单表    的增删改查接口
 * */


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

  
public class DBManager {
	private DBHelper helper;
	private SQLiteDatabase db;
	
	public DBManager(Context context) {
		helper = new DBHelper(context);
		//因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
		//所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
		db = helper.getWritableDatabase();
	}
	
	/**
	 * add user 
	 * @param person
	 */
	public void add(Person person) {
        db.beginTransaction();	//开始事务
        try {
        	
        	db.execSQL("INSERT INTO person VALUES(null, ?, ?, ?,?)", new Object[]{person.getName(),
        				person.getGender(), person.getPhone(), person.getDestination()});
        	
        	db.setTransactionSuccessful();	//设置事务成功完成
        } finally {
        	db.endTransaction();	//结束事务
        }
	}
	
	/**
	 * add order 
	 * @param order
	 */
	public void add(Order order) {
        db.beginTransaction();	//开始事务
        try {
        	
        	db.execSQL("INSERT INTO ord_list VALUES(null, ?, ?, ?, ?,?,?)", new Object[]{order.getOrderNumber(),
        			order.getTime(),order.getStatus(),order.getShopName(),order.getShopId()
        			,order.getPrice()});
        	
        	db.setTransactionSuccessful();	//设置事务成功完成
        } finally {
        	db.endTransaction();	//结束事务
        }
	}
	
	
	
	/**
	 * update person' information
	 * @param person
	 */
	public void updatePerson(Person person) {
		ContentValues cv = new ContentValues();
		cv.put("name", person.getName());
		cv.put("gender", person.getGender());
		cv.put("destination", person.getDestination());
		db.update("person", cv, "phone = ?", new String[]{person.getPhone()});
	}
	
	
	/**
	 * 更新订单,以唯一的订单号修改该对象
	 * @param order
	 */
	public void updateOrder(Order order) {
		ContentValues cv = new ContentValues();
		cv.put("ord_number", order.getOrderNumber());
		cv.put("time", order.getTime());
		cv.put("status", order.getStatus());
		cv.put("shop_name", order.getShopName());
		cv.put("shop_id", order.getShopId());
		cv.put("price", order.getPrice());
		db.update("ord_list", cv, "ord_number = ?", new String[]{order.getOrderNumber()});
	}
	
	
	
	/**
	 * delete  person
	 * @param person
	 */
	public void deletePerson(String phone) {
		db.delete("person", "phone = ?", new String[]{String.valueOf(phone)});
	}
	
	
	/**
	 *  删除订单,以订单号删除该订单
	 * @param orderNum
	 */
	public void deleteOrder(String orderNum) {
		db.delete("ord_list", "ord_number = ?", new String[]{String.valueOf(orderNum)});
	}
	
	
	
	/**
	 * query all persons, return list
	 * @return List<Person>
	 */
	public List<Person> queryAllPerson() {
		ArrayList<Person> persons = new ArrayList<Person>();
		Cursor c = queryThePersonCursor();
        while (c.moveToNext()) {
        	Person person = new Person();
        	
        	person.setName( c.getString(c.getColumnIndex("name")) );
        	person.setDestination( c.getString(c.getColumnIndex("destination")) );
        	person.setGender(c.getString(c.getColumnIndex("gender")) );
        	person.setPhone(c.getString(c.getColumnIndex("phone")));
        	persons.add(person);
        }
        c.close();
        return persons;
	}
	
	
	/**
	 * 查询所有订单
	 * @return List<Order>
	 */
	public List<Order> queryAllOrder() {
		ArrayList<Order> orders = new ArrayList<Order>();
		Cursor c = queryTheOrderCursor();
        while (c.moveToNext()) {
        	Order order = new Order();
        	
        	order.setOrderNumber(c.getString(c.getColumnIndex("ord_number")) );
        	order.setTime( c.getString(c.getColumnIndex("time")) );
        	order.setStatus(c.getString(c.getColumnIndex("status")) );
        	order.setShopName(c.getString(c.getColumnIndex("shop_name")));
        	order.setShopId(c.getString(c.getColumnIndex("shop_id")));
        	order.setPrice(c.getString(c.getColumnIndex("price")));
        	
        	orders.add(order);
        }
        c.close();
        return orders;
	}
	
	
	/**
	 * 按电话号码查询
	 * */
	
	public Person queryPerson(String phone) {  
       
        Cursor c = db.rawQuery("select * from person where phone=?", new String[]{phone.toString()});  
        Person person = new Person();  
        if(c.moveToFirst()) {  
            person.setName( c.getString(c.getColumnIndex("name")) );
        	person.setDestination( c.getString(c.getColumnIndex("destination")) );
        	person.setGender(c.getString(c.getColumnIndex("gender")) );
        	person.setPhone(c.getString(c.getColumnIndex("phone")));
        }  
        c.close();
        return person;  
    }  
      
	/**
	 * 按唯一订单号查询
	 * */
	
	public Order queryOrder(String orderNumber) {  
       
        Cursor c = db.rawQuery("select * from ord_list where ord_number=?", new String[]{orderNumber.toString()});  
        Order order = new Order();
        if(c.moveToFirst()) {  
        	order.setOrderNumber(c.getString(c.getColumnIndex("ord_number")) );
        	order.setTime(c.getString(c.getColumnIndex("time")));
        	order.setStatus(c.getString(c.getColumnIndex("status")));
        	
        	
        	order.setShopName(c.getString(c.getColumnIndex("shop_name")));
        	order.setShopId(c.getString(c.getColumnIndex("shop_id")));
        	order.setPrice(c.getString(c.getColumnIndex("price")));
        }  
        c.close();
        return order;  
    }  
	
	
	
	
	/**
	 * query all persons, orders, return cursor
	 * @return	Cursor
	 */
	public Cursor queryThePersonCursor() {
        Cursor c = db.rawQuery("SELECT * FROM person", null);
        
        return c;
	}
	
	public Cursor queryTheOrderCursor() {
        Cursor c = db.rawQuery("SELECT * FROM ord_list", null);
        
        return c;
	}
	
	/**
	 * close database
	 */
	public void closeDB() {
		db.close();
	}
}

package com.example.wmapp.data;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
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
        	
        	db.execSQL("INSERT INTO list VALUES(null, ?, ?, ?, ?,?,?)", new Object[]{order.getOrderNumber(),
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
	public void updateAge(Person person) {
		ContentValues cv = new ContentValues();
		cv.put("name", person.getName());
		cv.put("gender", person.getGender());
		cv.put("destination", person.getDestination());
		db.update("person", cv, "phone = ?", new String[]{person.getPhone()});
	}
	
	/**
	 * delete  person
	 * @param person
	 */
	public void deletePerson(String phone) {
		db.delete("person", "phone = ?", new String[]{String.valueOf(phone)});
	}
	
	/**
	 * query all persons, return list
	 * @return List<Person>
	 */
	public List<Person> query() {
		ArrayList<Person> persons = new ArrayList<Person>();
		Cursor c = queryTheCursor();
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
	
	public Order queryOrder(String number) {  
       
        Cursor c = db.rawQuery("select * from list where number=?", new String[]{number.toString()});  
        Order order = new Order();
        if(c.moveToFirst()) {  
        	order.setOrderNumber(c.getString(c.getColumnIndex("number")) );
        	order.setPrice(c.getString(c.getColumnIndex("price")));
        	order.setShopId(c.getString(c.getColumnIndex("shopid")));
        	order.setShopName(c.getString(c.getColumnIndex("shopname")));
        	order.setStatus(c.getString(c.getColumnIndex("status")));
        	order.setTime(c.getString(c.getColumnIndex("time")));
        }  
        c.close();
        return order;  
    }  
	
	
	
	
	/**
	 * query all persons, return cursor
	 * @return	Cursor
	 */
	public Cursor queryTheCursor() {
        Cursor c = db.rawQuery("SELECT * FROM person", null);
        
        return c;
	}
	
	/**
	 * close database
	 */
	public void closeDB() {
		db.close();
	}
}

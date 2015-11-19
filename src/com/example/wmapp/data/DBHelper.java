package com.example.wmapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * @author chengli
 * 
 * 数据库构建
 * 
 * */
public class DBHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "common.db";
	private static final int DATABASE_VERSION = 1;
	
	public DBHelper(Context context) {
		//CursorFactory设置为null,使用默认值
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		

		db.execSQL("CREATE TABLE IF NOT EXISTS  list " +   //  list 订单表 order不可用在对实体类的属性进行命名时，应避免"order"、"group"等SQL语句中的关键字
				"(  id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " number       VARCHAR, "
				+ " time         VARCHAR, "
				+ " status       VARCHAR,"
				+ " shopname     VARCHAR , "
				+ " shopid       VARCHAR, "
				+ " price        VARCHAR)");
		
		
		
		db.execSQL("CREATE TABLE IF NOT EXISTS person" +   //  person 表
				"(id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " name        VARCHAR,"
				+ " gender      VARCHAR, "
				+ " phone       VARCHAR, "
				+ " destination VARCHAR)");
		
		
		
	}

	//如果DATABASE_VERSION值被改为2,系统发现现有数据库版本不同,即会调用onUpgrade
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("ALTER TABLE person ADD COLUMN other STRING");
		db.execSQL("ALTER TABLE list  ADD COLUMN other STRING");
	}
}

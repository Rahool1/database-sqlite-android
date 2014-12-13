package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDataSource {
	
	private static final String LOGTAG = "EduTech";
	SQLiteOpenHelper dbhelper;
	SQLiteDatabase database;
	
	public MyDataSource(Context context) {
		dbhelper = new MyDBOpenHelper(context);
        
	}
	
	public void open(){
		Log.i(LOGTAG,"Database Opened");
		database = dbhelper.getWritableDatabase();
	}
	
	public void close(){
		Log.i(LOGTAG,"Database Closed");
		database.close();
	}
	
}

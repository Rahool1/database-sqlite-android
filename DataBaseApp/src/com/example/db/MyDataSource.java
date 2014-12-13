package com.example.db;

import com.example.model.Tour;

import android.content.ContentValues;
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
	
	 public Tour create(Tour tour){
	    	ContentValues values = new ContentValues();
	    	values.put(MyDBOpenHelper.COLUMN_TITLE,tour.getTitle());
	    	values.put(MyDBOpenHelper.COLUMN_DESC,tour.getDescription());
	    	values.put(MyDBOpenHelper.COLUMN_PRICE,tour.getPrice());
	    	values.put(MyDBOpenHelper.COLUMN_IMAGE,tour.getImage());
	    	long insertid = database.insert(MyDBOpenHelper.TABLE_TOURS, null, values);
	    	
	    	tour.setId(insertid);
	    	
	    	return tour;
	 }
}

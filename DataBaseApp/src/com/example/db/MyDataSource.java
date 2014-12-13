package com.example.db;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Tour;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDataSource {
	
	private static final String LOGTAG = "EduTech";
	SQLiteOpenHelper dbhelper;
	SQLiteDatabase database;

	private static final String[] allColumns = {
		MyDBOpenHelper.COLUMN_ID,
		MyDBOpenHelper.COLUMN_TITLE,
		MyDBOpenHelper.COLUMN_DESC,
		MyDBOpenHelper.COLUMN_PRICE,
		MyDBOpenHelper.COLUMN_IMAGE
	};
	
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
	
	public boolean removeFromDB(Tour tour){
		
		String where = MyDBOpenHelper.COLUMN_ID + "=" + tour.getId(); 
		Log.d(LOGTAG,"where :   " + where);
		int result = database.delete(MyDBOpenHelper.TABLE_TOURS, where, null);
		Log.d(LOGTAG,"result :   " + result);
		return (result == 1);
	}
	
	public List<Tour> findAll(){
		List<Tour> tours = new ArrayList<Tour>();
		
		Cursor cursor = database.query(MyDBOpenHelper.TABLE_TOURS, allColumns, 
				null, null, null, null, null);
		
		Log.i(LOGTAG,"Returned " + cursor.getCount() + " rows");
		
		if(cursor.getCount() > 0){
			while(cursor.moveToNext()){
				Tour tour = new Tour();
				tour.setId(cursor.getLong(cursor.getColumnIndex(MyDBOpenHelper.COLUMN_ID)));
				tour.setTitle(cursor.getString(cursor.getColumnIndex(MyDBOpenHelper.COLUMN_TITLE)));
				tour.setDescription(cursor.getString(cursor.getColumnIndex(MyDBOpenHelper.COLUMN_DESC)));
				tour.setImage(cursor.getString(cursor.getColumnIndex(MyDBOpenHelper.COLUMN_IMAGE)));
				tour.setPrice(cursor.getDouble(cursor.getColumnIndex(MyDBOpenHelper.COLUMN_PRICE)));
				tours.add(tour);
			}
		}
		
		return tours;
	}
	 
}

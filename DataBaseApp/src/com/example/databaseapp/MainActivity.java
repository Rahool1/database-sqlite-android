package com.example.databaseapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.db.MyDataSource;
import com.example.model.Tour;
 
public class MainActivity extends Activity {
	
	private static final String LOGTAG = "EduTech";
	MyDataSource datasource;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        datasource = new MyDataSource(this);
        datasource.open();
        createData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	datasource.open();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	datasource.close();
    }
    
    public void createData(){
    	
    	Tour tour = new Tour();
    	tour.setTitle("Mahabaleshwer");
    	tour.setDescription("Trip To Mahabaleshwar");
    	tour.setPrice(3000);
    	tour.setImage("mahabaleshwar");
    	
    	tour = datasource.create(tour);
    	Log.d(LOGTAG, "Tour Created and id is: " + tour.getId());
    	
    	Tour tour1 = new Tour();
    	tour1.setTitle("Gujrat");
    	tour1.setDescription("Trip To Gujrat");
    	tour1.setPrice(5000);
    	tour1.setImage("gujrat");
    	
    	tour1 = datasource.create(tour1);
    	Log.d(LOGTAG, "Tour Created and id is: " + tour1.getId());
    }
    
}

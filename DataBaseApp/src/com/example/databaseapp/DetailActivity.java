package com.example.databaseapp;

import java.text.NumberFormat;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Tour;

public class DetailActivity extends Activity {

	Tour tour;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tour_detail);

		Bundle b = getIntent().getExtras();
		tour = b.getParcelable(".model.Tour");
		
		refreshDisplay();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.action_remove:
			
			
			
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}

	private void refreshDisplay() {

		TextView tv = (TextView) findViewById(R.id.titleText);
		tv.setText(tour.getTitle());

//		NumberFormat nf = NumberFormat.getCurrencyInstance();
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "in"));

		TextView tv1 = (TextView) findViewById(R.id.priceText);
		tv1.setText(nf.format(tour.getPrice()));

		TextView tv2 = (TextView) findViewById(R.id.descText);
		tv2.setText(tour.getDescription());

		ImageView iv = (ImageView) findViewById(R.id.imageView1);
		int imageResource = getResources().getIdentifier(
				tour.getImage(), "drawable", getPackageName());
		if (imageResource != 0) {
			iv.setImageResource(imageResource);
		}

	}	
}

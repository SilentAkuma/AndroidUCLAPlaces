package com.example.placesinucla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
	}

	/** Called when the user clicks the Restaurants button */
	public void gotoRestaurants(View view) {
		// Do something in response to button
		Intent intent1 = new Intent(this, Restaurants.class);
		startActivity(intent1);
	}

	/** Called when the user clicks the Libraries button */
	public void gotoLibraries(View view) {
		// Do something in response to button
		Intent intent1 = new Intent(this, Libraries.class);
		startActivity(intent1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

package com.example.placesinucla;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Restaurants extends Activity {

	private boolean showAll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setShowAll(true);
		// setContentView(R.layout.activity_restaurants);

		updateList();
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
			setupActionBar();

		getActionBar().setDisplayHomeAsUpEnabled(true);

		updateList();
	}

	private void updateList() {
		// TODO: modify this function to add all the data

		// e.g
		ArrayList<String> restaurants = Retrieve.getRestaurant(this);

		ScrollView sv = new ScrollView(this);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		sv.addView(ll);

		TextView tv = new TextView(this);
		tv.setTextSize(30);
		tv.setText("     OPEN RESTAURANTS");
		ll.setBackgroundResource(R.drawable.bg);
		ll.addView(tv);

		for (int i = 0; i < restaurants.size(); i++) {
			Button b = new Button(this);
			b.setText(restaurants.get(i));
			ll.addView(b);
		}

		this.setContentView(sv);
		/*
		 * addContent("College Library", "All day"); if (showAll)
		 * addContent("Research Library", "8am-8pm");
		 */
	}

	/*private void addContent(String name, String hours) {
		TextView textViewName = new TextView(this);
		textViewName.setTextSize(15);
		textViewName.setText(name);

		TextView textViewHours = new TextView(this);
		textViewHours.setTextSize(12);
		textViewHours.setText("Hours: " + hours);

		// TODO: Need to change R.id.XXX and type (LinearLayout) below to add
		// component to the screen
		LinearLayout my_root = (LinearLayout) findViewById(R.id.LinearLayout_restaurants_list);
		LinearLayout A = new LinearLayout(this);
		A.setOrientation(LinearLayout.HORIZONTAL);
		A.addView(textViewName);
		A.addView(textViewHours);
		my_root.addView(A);
	}*/

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.restaurants, menu);
		return true;
	}

	public boolean isShowAll() {
		return showAll;
	}

	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

	public void onCheckboxClicked(View view) {
		boolean checked = ((CheckBox) view).isChecked();
		if (checked)
			setShowAll(false);
		else
			setShowAll(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

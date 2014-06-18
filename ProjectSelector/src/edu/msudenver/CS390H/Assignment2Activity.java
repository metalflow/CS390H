package edu.msudenver.CS390H;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Assignment2Activity extends FragmentActivity implements
		Assignment2ListFragment.OnItemSelectedListener {

	Assignment2ListFragment firstFrag;
	Assignment2ImageFragment secondFragment;

	public void onCreate(Bundle savedInstanceState) {
		Log.i("Assignment2Activity_OnCreate", "On create Started");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.assignment2_main);

		if (savedInstanceState != null) {
			return;
		}

		firstFrag = new Assignment2ListFragment();

		getSupportFragmentManager().beginTransaction()
				.add(R.id.fragment_container, firstFrag).commit();
		Log.i("Assignment2Activity_OnCreate", "On create finished");
	}

	public void onItemSelected(String imagename) {

		// Assignment2ImageFragment imageFrag = (Assignment2ImageFragment)
		// getSupportFragmentManager().findFragmentById(R.id.listImageViewer);

		secondFragment = new Assignment2ImageFragment();
		Bundle args = new Bundle();
		args.putString(Assignment2ImageFragment.IMAGETODISPLAY, imagename);
		secondFragment.setArguments(args);
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_container, secondFragment);
		transaction.addToBackStack(null);
		transaction.commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.assignment2_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.assignment2_menuoption_back:
			backToMainList();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void backToMainList() {
		getSupportFragmentManager().popBackStack();
	}
}
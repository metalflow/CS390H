package edu.msudenver.CS390H;

import android.app.*;
import android.os.*;
import android.util.Log;
import android.view.*;
import android.widget.*;

public class InClass0604Activity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inclass0604);
	}

	public void onResume(Bundle savedInstanceState){
		/*
		 final Button button = (Button) findViewById(R.id.myFirstButton);
		 button.setOnClickListener(new View.OnClickListener() {
		 public void onClick(View v) {
		 //perform action
		 }
		 } );
		 */
	}

	public void selfDestruct(View view) {
		Log.i("InClass0604_selfDestruct", "button pressed");
	}
}

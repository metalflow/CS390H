package edu.msudenver.CS390H;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class Assignment2Activity extends Activity {

	ArrayAdapter MainList;
	List Listofstuff;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.assignment2);
	}

	@Override
	public void onResume(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		
		if (savedInstanceState.get("MainList")==null)
	    	MainList = new ArrayAdapter(this,findViewById(R.id.mainListView,Listofstuff);
		else
			MainList = (ArrayAdapter) savedInstanceState.get("MainList");
	}
	
}

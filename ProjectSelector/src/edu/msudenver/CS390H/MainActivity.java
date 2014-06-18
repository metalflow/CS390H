package edu.msudenver.CS390H;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.util.Log;
import android.view.*;

public class MainActivity extends Activity
{
	private Intent launchProjectIntent = new Intent();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.i("MainActivity_OnCreate", "On create finished");
    }
	
	public void executeInClass0604 (View view){
		Log.i("MainActivity_executeInClass0604", "button pressed");
		launchProjectIntent = new Intent(this, InClass0604Activity.class);
		startActivity(launchProjectIntent);
	}
	
	public void executeAssignment1 (View view){
		Log.i("MainActivity_executeAssignment1", "button pressed");
		launchProjectIntent = new Intent(this, assignment1Activity.class);
		startActivity(launchProjectIntent);
	}
	
	public void executeAssignment2 (View view){
		Log.i("MainActivity_executeAssignment2", "button pressed");
		launchProjectIntent = new Intent(this, Assignment2Activity.class);
		startActivity(launchProjectIntent);
	}
}

package edu.msudenver.CS390H;

import android.app.*;
import android.os.*;
import android.util.Log;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
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
	}
	
	public void executeAssignment1 (View view){
		Log.i("MainActivity_executeAssignment1", "button pressed");
	}
	
	
}

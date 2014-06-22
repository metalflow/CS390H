package edu.msudenver.CS390H;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.util.Log;
import android.view.*;

public class ColorBlenderActivity extends Activity
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
	}

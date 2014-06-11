package edu.msudenver.CS390H;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;

public class assignment1Activity extends Activity {
	
	private static NumberPicker redNP = new NumberPicker(null);
	private static NumberPicker greenNP = new NumberPicker(null);
	private static NumberPicker blueNP = new NumberPicker(null);
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment1);
        
        redNP = (NumberPicker) findViewById(R.id.redNumberPicker);
        
        Log.i("Assignemtn1_OnCreate", "On create finished");
        
    }

    public void updateColor(View view){
    	Log.i("Assignemtn1_updateColor", "surface has been clicked");
    }
}

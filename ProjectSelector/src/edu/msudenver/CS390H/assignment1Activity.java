package edu.msudenver.CS390H;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;
import android.view.*;
import android.graphics.*;

public class assignment1Activity extends Activity {
	
	private static NumberPicker redNP = null;
	private static NumberPicker greenNP = null;
	private static NumberPicker blueNP = null;
	private static SurfaceView colorSurface=null;
	private static Canvas colorCanvas=null;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment1);
        
        redNP = (NumberPicker) findViewById(R.id.redNumberPicker);
        greenNP = (NumberPicker) findViewById(R.id.greenNumberPicker);
        blueNP = (NumberPicker) findViewById(R.id.blueNumberPicker);
        
		redNP.setMinValue(0);
		redNP.setMaxValue(255);
		greenNP.setMinValue(0);
		greenNP.setMaxValue(255);
		blueNP.setMinValue(0);
		blueNP.setMaxValue(255);
		
		colorSurface = (SurfaceView) findViewById(R.id.colorView);
		colorCanvas = new Canvas();
		
        Log.i("Assignemtn1_OnCreate", "On create finished");
        
    }

    public void updateColor(View view){
		colorCanvas.drawARGB(0,redNP.getValue(),greenNP.getValue(),blueNP.getValue());
		colorSurface.draw(colorCanvas);
    	Log.i("Assignemtn1_updateColor", "surface has been clicked");
    }
}

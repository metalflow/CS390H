package edu.msudenver.CS390H;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.hardware.*;
import android.content.Context;
import java.util.List;
import android.view.View;
import android.widget.*;
import android.graphics.Color;

public class InClass0625Activity extends Activity implements SensorEventListener
{
	private SensorManager mSensorManager;
	private List <Sensor> deviceSensors;
	private TextView readout;
	private View visualizer;
	private Sensor mSensor;
	private float[] gravityValues;
	
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.inclass0625);
	
		readout = (TextView) findViewById(R.id.readoutView);
		visualizer = findViewById(R.id.visualResponseView);
		mSensorManager  = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
		
		readout.setTextColor(Color.WHITE);
		
		Log.i("InClass0625Activity_OnCreate", "On create finished");
	}
	
	@Override
	public void onStart()
	{
		super.onStart();

		for (Sensor device : deviceSensors){
			readout.append(device.getName() + '\n');	
		}

		if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null)
		{
			mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			readout.append("Using Gravity Sensor:"+ mSensor.getName() +'\n');
		} else
			readout.append("NO GAVITY SENSOR!" +'\n');
		
	}
	
	@Override
	public void onResume()
	{
		super.onResume();

		mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
			
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		mSensorManager.unregisterListener(this);
	}
	
	@Override
	public final void onAccuracyChanged(Sensor sensor, int accuracy) {
		// Do something here if sensor accuracy changes.
	}

	@Override
	public final void onSensorChanged(SensorEvent event) {
		gravityValues = event.values;
		for (float value : gravityValues){
			readout.append(""+value+'\n');
		}
	}
	
}

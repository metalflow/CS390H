package edu.msudenver.CS390H;

import java.net.URI;

import android.app.*;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import android.view.*;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ColorBlenderActivity extends Activity {
	final int LEFT = 0;
	final int RIGHT = 1;
	private Intent launchProjectIntent;
	private View leftView;
	private View rightView;
	private View blendedView;
	private SeekBar colorSlider;
	private int leftColor;
	private int rightColor;
	private int blendedColor;
	private colorSliderListener sliderListener = new colorSliderListener();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colorblenderactivity);
		Log.i("ColorBlenderActivity_OnCreate", "On create started");

		leftView = findViewById(R.id.leftColor);
		rightView = findViewById(R.id.rightColor);
		blendedView = findViewById(R.id.blendedColor);
		colorSlider = (SeekBar) findViewById(R.id.colorSeekBar);

		colorSlider.setOnSeekBarChangeListener(sliderListener);
		leftColor = getColor(leftView);
		rightColor = getColor(rightView);
		blendedColor = blendColor(0, leftColor, rightColor);
		blendedView.setBackgroundColor(blendedColor);

		Log.i("ColorBlenderActivity_OnCreate", "On create finished");
	}

	@Override
	public void onStart() {
		super.onStart();
		// setContentView(R.layout.colorblenderactivity);
		Log.i("ColorBlenderActivity_onStart", "On start started");

		/*
		 * leftView.setBackgroundColor(leftColor);
		 * rightView.setBackgroundColor(rightColor);
		 * blendedView.setBackgroundColor(blendedColor);
		 */
		Log.i("ColorBlenderActivity_onStart", "On start finished");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		int color = data.getIntExtra("COLOR_PICKED", 0);

		if (resultCode != RESULT_OK) {
			Log.i("ColorBlenderActivity_onActivityResult", "ColorPicker returned error code:"
					+ resultCode);
			return;
		}
		
		switch (requestCode) {
		case LEFT:
			leftView.setBackgroundColor(color);
			Log.i("ColorBlenderActivity_onActivityResult", "LEFT color set to:"
					+ color);
			break;
		case RIGHT:
			rightView.setBackgroundColor(color);
			Log.i("ColorBlenderActivity_onActivityResult",
					"RIGHT color set to:" + color);
			break;
		default:
			Log.i("ColorBlenderActivity_onActivityResult",
					"invalid requestCode recieved:" + requestCode);
			break;
		}
	}

	public void setRightColor(View view) {
		launchProjectIntent = new Intent(this, assignment1Activity.class);
		startActivity(launchProjectIntent);
		Log.i("ColorBlenderActivity_setRightColor", "setRightColor finished");
	}

	public void setLeftColor(View view) {
		Uri data = Uri.withAppendedPath(Uri.EMPTY, "COLOR").;
		launchProjectIntent = new Intent("COLOR_PICK", data, this.getApplicationContext().getApplicationContext(), assignment1Activity.class);
		startActivity(launchProjectIntent);
		Log.i("ColorBlenderActivity_setLeftColor", "setLeftColor finished");
	}

	private int getColor(View view) {
		ColorDrawable output = (ColorDrawable) view.getBackground();
		return output.getColor();
	}

	private int blendColor(int rightPercent, int left, int right) {
		Log.i("ColorBlenderActivity_blendColor", "left:" + left);
		Log.i("ColorBlenderActivity_blendColor", "right:" + right);

		int leftRed = Color.red(left);
		int leftBlue = Color.blue(left);
		int leftGreen = Color.green(left);
		int rightRed = Color.red(right);
		int rightBlue = Color.blue(right);
		int rightGreen = Color.green(right);
		int leftPercent = 100 - rightPercent;

		Log.i("ColorBlenderActivity_blendColor", "leftRed:" + leftRed);
		Log.i("ColorBlenderActivity_blendColor", "leftBlue:" + leftBlue);
		Log.i("ColorBlenderActivity_blendColor", "leftGreen:" + leftGreen);
		Log.i("ColorBlenderActivity_blendColor", "leftPercent:" + leftPercent);
		Log.i("ColorBlenderActivity_blendColor", "rightRed:" + rightRed);
		Log.i("ColorBlenderActivity_blendColor", "rightBlue:" + rightBlue);
		Log.i("ColorBlenderActivity_blendColor", "rightGreen:" + rightGreen);
		Log.i("ColorBlenderActivity_blendColor", "rightPercent:" + rightPercent);

		return Color.rgb(
				(leftRed * leftPercent + rightRed * rightPercent) / 100,
				(leftGreen * leftPercent + rightGreen * rightPercent) / 100,
				(leftBlue * leftPercent + rightBlue * rightPercent) / 100);
	}

	private class colorSliderListener implements OnSeekBarChangeListener {
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			blendedColor = blendColor(progress, leftColor, rightColor);
			blendedView.setBackgroundColor(blendedColor);
			blendedView.invalidate();
			Log.i("ColorBlenderActivity_onProgressChanged",
					"onProgressChanged finished");
			Log.i("ColorBlenderActivity_onProgressChanged", "blendedColor:"
					+ blendedColor);
			Log.i("ColorBlenderActivity_onProgressChanged", "progress:"
					+ progress);
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			Log.i("ColorBlenderActivity_onStartTrackingTouch",
					"onStartTrackingTouch finished");
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			Log.i("ColorBlenderActivity_onStopTrackingTouch",
					"onStopTrackingTouch finished");
		}
	}

}

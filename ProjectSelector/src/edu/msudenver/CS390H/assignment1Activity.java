package edu.msudenver.CS390H;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.graphics.*;

public class assignment1Activity extends Activity {

	private static NumberPicker redNP = null;
	private static NumberPicker greenNP = null;
	private static NumberPicker blueNP = null;
	private static ImageView drawingImageView = null;
	private boolean intentFlag = false;
	private Uri data;
	private Intent passedIntent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.assignment1);

		passedIntent = getIntent();
		data = passedIntent.getData();

		if (passedIntent != null) {
			if (passedIntent.getType().equals("number/integer")) {
				intentFlag = true;
			} else {
				Log.i("Assignemtn1_OnCreate", "bad MIME type recieved");
				onStop();
			}
		}

		redNP = (NumberPicker) findViewById(R.id.redNumberPicker);
		greenNP = (NumberPicker) findViewById(R.id.greenNumberPicker);
		blueNP = (NumberPicker) findViewById(R.id.blueNumberPicker);

		OnValueChangeListener colorValueChangeListener = new OnValueChangeListener() {
			@Override
			public void onValueChange(NumberPicker picker, int oldVal,
					int newVal) {
				Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
						.getDefaultDisplay().getWidth(),
						(int) getWindowManager().getDefaultDisplay()
								.getHeight(), Bitmap.Config.ARGB_8888);
				Canvas canvas = new Canvas(bitmap);
				drawingImageView.setImageBitmap(bitmap);

				canvas.drawRGB(redNP.getValue(), greenNP.getValue(),
						blueNP.getValue());
			}
		};

		redNP.setMinValue(0);
		redNP.setMaxValue(255);
		greenNP.setMinValue(0);
		greenNP.setMaxValue(255);
		blueNP.setMinValue(0);
		blueNP.setMaxValue(255);

		drawingImageView = (ImageView) this.findViewById(R.id.DrawingImageView);
		Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
				.getDefaultDisplay().getWidth(), (int) getWindowManager()
				.getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		drawingImageView.setImageBitmap(bitmap);

		// Rectangle

		Paint paint = new Paint();
		paint.setColor(Color.rgb(redNP.getValue(), greenNP.getValue(),
				blueNP.getValue()));
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		paint.setStrokeWidth(10);
		float leftx = 0;
		float topy = 0;
		float rightx = bitmap.getWidth();
		float bottomy = bitmap.getHeight();

		canvas.drawRect(leftx, topy, rightx, bottomy, paint);

		redNP.setOnValueChangedListener(colorValueChangeListener);
		greenNP.setOnValueChangedListener(colorValueChangeListener);
		blueNP.setOnValueChangedListener(colorValueChangeListener);

		Log.i("Assignemtn1_OnCreate", "On create finished");

	}

	@Override
	public void onStop() {
		super.onStop();

		passedIntent.putExtra(
				"COLOR",
				Color.rgb(redNP.getValue(), greenNP.getValue(),
						blueNP.getValue()));
		setResult(Activity.RESULT_OK, passedIntent);
		finish();
	}

	public void updateColor(View view) {
		Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
				.getDefaultDisplay().getWidth(), (int) getWindowManager()
				.getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		drawingImageView.setImageBitmap(bitmap);

		canvas.drawRGB(redNP.getValue(), greenNP.getValue(), blueNP.getValue());

		if (intentFlag) {
			passedIntent.putExtra(
					"COLOR",
					Color.rgb(redNP.getValue(), greenNP.getValue(),
							blueNP.getValue()));
			setResult(Activity.RESULT_OK, passedIntent);
			finish();
		}
	}
}

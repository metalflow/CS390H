package edu.msudenver.CS390H;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.content.Context;
import android.widget.Toast;
import android.text.*;

public class InClass0623Activity extends Activity
{	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
		//setContentView(R.layout.inclass0623);
		//MyView touchSensor = (MyView) findViewById(R.id.touchView);
		
		Log.i("InClass0623Activity_onCreate", "onCreate finished");
		}
	
	private class MyView extends View {
		public MyView(Context inherit){
			super(inherit);
		}
		
		@Override
		public boolean onTouchEvent(MotionEvent move) {
			String actionType = null;
			
			
			switch (move.getAction()) {
				case move.ACTION_POINTER_DOWN :
					actionType = "Pointer Down";
					break;
				case move.ACTION_DOWN :
					actionType = "Down";
					break;
				case move.ACTION_UP :
					actionType = "Up";
					break;
				case move.ACTION_MOVE :
					actionType = "Move";
					break;
					default:
					actionType = "Unknown Action (type "+move.getAction()+")";
					break;
			}
			
			
			Context context = getApplicationContext();
			CharSequence text = "pointer index:" + move.getActionIndex() + " has " + actionType + " at:" + move.getX() + "," + move.getY();
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			
			Log.i("MyView_onTouchEvent", "onTouchEvent finished");
			return true;
		}
	}	
}

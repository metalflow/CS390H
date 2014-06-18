package edu.msudenver.CS390H;

import android.support.v4.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Assignment2ImageFragment extends Fragment {
	//private static ImageView drawingImageView = null;
	final static String IMAGETODISPLAY = "Name of the Image to Display";
	String imageName = "default";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (savedInstanceState != null) {
			imageName = savedInstanceState.getString(IMAGETODISPLAY);
		}

		return inflater.inflate(R.layout.assignment2_image_view, container,
				false);
	}

	@Override
	public void onStart() {
		super.onStart();

		Bundle args = getArguments();
		if (args != null) {

			updateImageView(args.getString(IMAGETODISPLAY));
		} else if (!imageName.equalsIgnoreCase("default")) {
			updateImageView(imageName);
		}
	}

	public void updateImageView(String newImageName) {
		Drawable picture = null;
		ImageView image = (ImageView) getActivity().findViewById(
				R.id.listImageViewer);

		if (newImageName.equalsIgnoreCase("dog")) {
			picture = getResources().getDrawable(R.drawable.dog);
		} else if (newImageName.equalsIgnoreCase("bird")) {
			picture = getResources().getDrawable(R.drawable.bird);
		} else if (newImageName.equalsIgnoreCase("fish")) {
			picture = getResources().getDrawable(R.drawable.fish);
		} else {
			picture = getResources().getDrawable(R.drawable.cat);
		}

		image.setImageDrawable(picture);
		imageName = newImageName;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putString(IMAGETODISPLAY, imageName);
	}
}

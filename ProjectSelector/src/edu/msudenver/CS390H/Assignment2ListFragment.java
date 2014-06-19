package edu.msudenver.CS390H;

import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Assignment2ListFragment extends Fragment {
	


	OnItemSelectedListener activityCall;
	ListView lv;
	ArrayAdapter<String> listAdapter;
	ViewGroup hostContainer;
	OnItemClickListener listClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
			Log.i("Assignment2ListFragment_listClickListener", "parent " + parent);
			Log.i("Assignment2ListFragment_listClickListener", "view " + view);
			Log.i("Assignment2ListFragment_listClickListener", "position " + position);
			Log.i("Assignment2ListFragment_listClickListener", "id " + id);
			
			activityCall.onItemSelected(parent.getItemAtPosition(position).toString());
			
		}

	};
	
    public interface OnItemSelectedListener {
        public void onItemSelected(String itemName);
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("Assignment2ListFragment_onCreateView", "On create started");
		if (container == null) {
			return null;
		}
		View view = inflater.inflate(R.layout.assignment2_list_view, container,
				false);

		lv = (ListView) view.findViewById(R.id.mainListView);

		String[] values = new String[] { "cat", "dog", "bird", "fish" };

		ArrayAdapter<String> files = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, values);

		lv.setAdapter(files);
		lv.setOnItemClickListener(listClickListener);
		return view;
	}
	
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            activityCall = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnItemSelectedListener");
        }
    }

}

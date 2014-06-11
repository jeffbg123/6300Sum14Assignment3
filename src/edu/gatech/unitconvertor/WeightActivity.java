package edu.gatech.unitconvertor;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.os.Build;

public class WeightActivity
extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	public void handleClick(View view) {
		boolean checked = ((RadioButton)view).isChecked();
		EditText txt = (EditText)findViewById(R.id.textWeight);
		double Weight = Double.parseDouble(txt.getText().toString());
		
		switch(view.getId()) {
		case R.id.radioPounds:
			if(checked)
				txt.setText(kilogramsToPounds(Weight));
			break;
		case R.id.radioKilograms:
			if(checked)
				txt.setText(poundsToKilograms(Weight));
		}
				
	
	}
	
	public String poundsToKilograms(double pounds) {
		double kilograms = pounds/2.20462;
		return String.valueOf(kilograms);
	}
	
	public String kilogramsToPounds(double kilograms) {
		double pounds = kilograms*2.20462;
		return String.valueOf(pounds);
	}
	
	public void handleClickBack(View view) {
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);;
				
	
	}
}

package com.deepak.pizzadelivery;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StartingPoint extends Activity implements OnClickListener{
	
	public EditText username;
	String user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startingpoint);
		
		username = (EditText)findViewById(R.id.name);
		Button getstartedbutton = (Button)findViewById(R.id.get_started_button);
		
		getstartedbutton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {

		user = username.getText().toString();
		switch (v.getId()) {
		case R.id.get_started_button:
			if (user.equals("") || user == null) // if no name entered
			{
				new AlertDialog.Builder(this).setTitle("Incomplete Information").setMessage("Enter your name before placing order").setCancelable(false)
						.setNeutralButton("OK", new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss();
							}
						}).show();
			} 
			else //going to order page
			{
				Intent i = new Intent(this, OrderPage.class);
				startActivity(i);
			}
			break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			//			settings activity can be defined
			return true;
		case R.id.help:
			new AlertDialog.Builder(this).setTitle("Help!")
			.setMessage("Enter your name in the box to proceed").setCancelable(false)
					.setNeutralButton("OK", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					}).show();
			return true;
		case R.id.exit:
			new AlertDialog.Builder(this).setTitle("Exit").setMessage("Are you sure you want to exit?").setCancelable(true)
					.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							finish();
							System.exit(0);
						}
					}).setNegativeButton("No", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					}).show();
			return true;
		}
		return false;
	}

}

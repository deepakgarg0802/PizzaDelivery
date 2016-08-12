package com.deepak.pizzadelivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		Thread timer = new Thread()
		{
			@Override
			public void run() {
				
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					Intent intent = new Intent(getApplicationContext(),StartingPoint.class);
					startActivity(intent);
				}
			}
		};
		timer.start();
	}

}

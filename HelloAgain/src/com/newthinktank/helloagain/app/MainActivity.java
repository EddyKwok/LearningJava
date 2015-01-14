package com.newthinktank.helloagain.app;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.MenuItem;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		final TextView firstTextView = (TextView) findViewById(R.id.textView);
		
		Button firstButton = (Button) findViewById(R.id.firstButton);
		
		firstButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String message = "You Clicked";
				if (firstTextView.getText().equals(message))
					message = "You have been clicked.";
				firstTextView.setText(message);
			}
		});
    }
	
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is press
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	*/
}

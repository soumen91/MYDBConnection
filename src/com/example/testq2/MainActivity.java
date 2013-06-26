package com.example.testq2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText mValue;
	private Button mClick;
	private TestDbAdapter mDb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mValue = (EditText)findViewById(R.id.editText1);
		mClick = (Button)findViewById(R.id.button1);
		mDb = TestDbAdapter.createInstance(getApplicationContext());
		
		mClick.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
			if(mValue.getText().toString().trim().length()>0){
			mDb.inserValue(mValue.getText().toString().trim());	
			}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

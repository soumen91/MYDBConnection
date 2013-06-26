package com.example.testq2;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText mValue;
	private Button mClick;
	private TestDbAdapter mDb;
	private Button mShow;
	private TextView txtvw;
	public List<String> lst = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mValue = (EditText)findViewById(R.id.editText1);
		mClick = (Button)findViewById(R.id.button1);
		txtvw=(TextView)findViewById(R.id.textView1);
		mDb = TestDbAdapter.createInstance(getApplicationContext());
		mShow=(Button)findViewById(R.id.button2);
		
		
		mClick.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
			if(mValue.getText().toString().trim().length()>0){
			mDb.inserValue(mValue.getText().toString().trim());	
			mValue.setText("");
			}
			}
		});
		mShow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				txtvw.setText("");
				
				lst=mDb.getdata();
				for(int i=0 ; i<lst.size();i++){
					txtvw.append(lst.get(i)+"\n");
				}
			}
		});
	}

}

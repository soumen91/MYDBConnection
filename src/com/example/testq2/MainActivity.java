package com.example.testq2;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
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
	private Button mUpDate;
	private EditText edtxt;
	private Button mDel;
	private TextView txtvw;
	public List<String> lst = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mValue = (EditText)findViewById(R.id.editText1);
		mClick = (Button)findViewById(R.id.button1);
		txtvw=(TextView)findViewById(R.id.textView1);
		edtxt=(EditText)findViewById(R.id.editText2);
		
		mShow=(Button)findViewById(R.id.button2);
		mUpDate=(Button)findViewById(R.id.button3);
		mDel=(Button)findViewById(R.id.bttndel);
		
		mDb = TestDbAdapter.createInstance(getApplicationContext());
		
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
		
		mUpDate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(edtxt.getText().toString().trim().length()>0){
					mDb.UpdateValue(edtxt.getText().toString().trim());
					edtxt.setText("");
				}
				
			}
		});
		
		mDel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mDb.deleteContact();
				
			}
		});
		
	}

}

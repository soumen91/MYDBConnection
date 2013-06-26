package com.example.testq2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TestHelper extends SQLiteOpenHelper{

	public TestHelper(Context context) {
		super(context, TestConstant.DATABASE_NAME, null, TestConstant.DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		TestCreate.onCreate(db);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		TestCreate.onUpgrade(db, oldVersion, newVersion);	
		
	}

}

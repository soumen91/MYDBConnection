package com.example.testq2;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TestCreate {

	public static final String TABLE_TEST_CREATE = "CREATE TABLE "
			+ TestConstant.TABLE_NAME + " (" + TestConstant.ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + TestConstant.NAME
			+ " TEXT)";
	
	public static void  onCreate(SQLiteDatabase db){
		db.beginTransaction();
		Log.i("Table created", "Table created");
		try{
			db.execSQL(TABLE_TEST_CREATE);
			db.setTransactionSuccessful();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			db.endTransaction();
		}
		
	}
	
	public static void  onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		Log.w(TestCreate.class.getName(), "Upgrade database from version "+oldVersion+" to "+newVersion+"");
		db.execSQL("DROP TABLE IF EXISTS "+TestConstant.TABLE_NAME);
		onCreate(db);
	}

}

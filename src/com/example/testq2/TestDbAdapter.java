package com.example.testq2;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class TestDbAdapter {
	
	public static Context sContext;
	public static SQLiteDatabase sDb;
	public static TestHelper mHelper;
	public static TestDbAdapter sInstance;
	
	
	private TestDbAdapter(Context sContext) {
		TestDbAdapter.sContext = sContext;
	}
	
	public static TestDbAdapter createInstance(Context sContext){
		if(sInstance == null){
			sInstance = new TestDbAdapter(sContext);
			open();
		}
		
		return sInstance;
	}

	private static void open() {
		mHelper  = new TestHelper(sContext);
		sDb = mHelper.getWritableDatabase();
		
	}
	private  void close() {
		mHelper.close();
	}
	
	public long inserValue(String name){
	  ContentValues values = new ContentValues();
	  values.put(TestConstant.NAME, name);
	  
	  try{
		  sDb.beginTransaction();
		  final long state   = sDb.insert(TestConstant.TABLE_NAME, null, values);
		  sDb.setTransactionSuccessful();
		  return state;
	  }catch(SQLException e){
		  throw e;
	  }finally{
		  sDb.endTransaction();
	  }
	  
	}
	
	public List<String>  getdata(){	    
		 List<String> data = new ArrayList<String>();
	    Cursor cursor = sDb.query(TestConstant.TABLE_NAME, new String[] {TestConstant.ID,TestConstant.NAME}, null, null, null, null, null);
	    if(cursor.getCount()>0){
	    	cursor.moveToFirst();
	    	while(!cursor.isAfterLast()){
	    		String name = cursor.getString(1);
	    		data.add(name);
	    		cursor.moveToNext();
	    	}
	    }
	    cursor.close();
		return data;   
	   
	}
    // Updating single contact
	public boolean UpdateValue(String name){
		  ContentValues values = new ContentValues();
		  values.put(TestConstant.NAME, name);
		  
		  try{
			  sDb.beginTransaction();
			  final boolean state   = sDb.update(TestConstant.TABLE_NAME, values, TestConstant.ID + "="+"1", null)>0;
			  sDb.setTransactionSuccessful();
			  return state;
		  }catch(SQLException e){
			  throw e;
		  }finally{
			  sDb.endTransaction();
		  }
		  
		}
	public void deleteContact() {
	    
	    sDb.delete(TestConstant.TABLE_NAME, TestConstant.ID + " = 4",null);
	    //sDb.close();
	}
		
	}

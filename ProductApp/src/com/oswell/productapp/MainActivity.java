package com.oswell.productapp;

import java.util.ArrayList;
import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity
{
	int count=0;
	ListView lView;
	EditText et_NoofProducts;
	String str="";
	 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lView=(ListView)findViewById(R.id.listView1);
		et_NoofProducts=(EditText)findViewById(R.id.editTextProducts);
		count=Integer.parseInt(et_NoofProducts.getText().toString());
		ApplicationConstant.AllProducts=new ArrayList<Product>();
		setUIProducts(count);
		
		
		
	}
	
	public void addProducts(View v)
	{
		
		count=Integer.parseInt(et_NoofProducts.getText().toString());
		//Toast.makeText(getApplicationContext(), "Count:"+count, 2000).show();
		setUIProducts(count);
		
		
		
	}
	
	public void setUIProducts(int count)
	
	{
		ApplicationConstant.AllProducts.clear();
		lView.setAdapter(new MyAdapter(this,count));
	}
	
	public void submit(View v)
	{
		for(int i=1;i<=count;i++)
		{
			/*
			int resourse1=this.getResources().getIdentifier("Name"+i, "id", this.getPackageName());
			EditText et_Name=(EditText)findViewById(resourse1);
			
			int resourse2=this.getResources().getIdentifier("Quantity"+i, "id", this.getPackageName());
			EditText et_quantity=(EditText)findViewById(resourse2);
			
			int resourse3=this.getResources().getIdentifier("Price"+i, "id", this.getPackageName());
			EditText et_price=(EditText)findViewById(resourse3);
			*/
			
			
			EditText et_Name=(EditText)findViewById(((i-1)*4)+1);
			EditText et_quantity=(EditText)findViewById(((i-1)*4)+2);
			EditText et_price=(EditText)findViewById(((i-1)*4)+3);
			
			Log.v(getPackageName(), "name id:"+et_Name.getId()+"\n quantity id:"+et_quantity.getId()+"price id :"+et_price.getId());
			
			//Toast.makeText(getApplicationContext(), "name id:"+et_Name.getId()+"\n quantity id:"+et_quantity, 5000).show();
			
			
			Product pro=new Product();
			
			pro.setStrName(et_Name.getText().toString());
			pro.setStrQuantity(et_quantity.getText().toString());
			pro.setStrPrice(et_price.getText().toString());
			
			ApplicationConstant.AllProducts.add(pro);
		}
		
		if(count>0)
		{
			
			Intent i=new Intent(getApplicationContext(),ViewProductsActivity.class);
			startActivity(i);
		}
		//Toast.makeText(getApplicationContext(), " Name : "+str, 2000).show();
	}
	
	public void upload(View v)
	{
		
		Intent i=new Intent(getApplicationContext(),MultiPhotoSelectActivity.class);
		startActivity(i);
	}

	

}

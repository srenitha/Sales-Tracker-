package com.oswell.productapp;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends BaseAdapter
{
	MainActivity mActivity;
	int count;
	TextView tv1;
	EditText et1,et2,et3;
	float price=0,quantity=0;
	
	
	
	
	MyAdapter(MainActivity mActivity,int count)
	{
		this.mActivity=mActivity;
		this.count=count;
		
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View ConvertView, ViewGroup parent) 
	{
		// TODO Auto-generated method stub
		LayoutInflater inflater=LayoutInflater.from(mActivity);
		ConvertView=inflater.inflate(R.layout.indi_view, null);
		
		tv1=(TextView)ConvertView.findViewById(R.id.srno);
		tv1.setText(""+(position+1));
		et1=(EditText)ConvertView.findViewById(R.id.etname);
		et2=(EditText)ConvertView.findViewById(R.id.etquantity);
		et3=(EditText)ConvertView.findViewById(R.id.etprice);
		//et4=(EditText)ConvertView.findViewById(R.id.ettotal);
		
		/*
		int resourse1=mActivity.getResources().getIdentifier("Name"+(position+1), "id", mActivity.getPackageName());
		et1.setId(resourse1);
		
		int resourse2=mActivity.getResources().getIdentifier("Quantity"+(position+1), "id", mActivity.getPackageName());
		et2.setId(resourse2);
		
		int resourse3=mActivity.getResources().getIdentifier("Price"+(position+1), "id", mActivity.getPackageName());
		et3.setId(resourse3);
		
		int resourse4=mActivity.getResources().getIdentifier("Total"+(position+1), "id", mActivity.getPackageName());
		et4.setId(resourse4);
		*/
		
		/*et1.setTag("Name"+position);
		et1.setId(resourse1);
		et2.setTag("Quantity"+position);
		et2.setId(position+1);
		et3.setTag("Price"+position);
		et3.setId(position+2);
		et4.setTag("Total"+position);
		et4.setId(position+3);
		*/
		
		et1.setId((position*4)+1);
		et2.setId((position*4)+2);
		et3.setId((position*4)+3);
		//et4.setId((position*4)+4);
		
		
		return ConvertView;
	}

}

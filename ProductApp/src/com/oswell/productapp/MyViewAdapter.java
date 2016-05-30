package com.oswell.productapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyViewAdapter extends BaseAdapter
{
	ViewProductsActivity viewActivity;

	MyViewAdapter(ViewProductsActivity viewActivity)
	{
		this.viewActivity=viewActivity;
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ApplicationConstant.AllProducts.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		// TODO Auto-generated method stub
		LayoutInflater inflater=LayoutInflater.from(viewActivity);
		convertView=inflater.inflate(R.layout.indi_product_view, null);
		
		Product p=(Product)ApplicationConstant.AllProducts.get(position);
		
		TextView tv0=(TextView)convertView.findViewById(R.id.textViewSrNo);
		tv0.setText(""+(position+1));
		
		TextView tv1=(TextView)convertView.findViewById(R.id.textViewName);
		tv1.setText(p.getStrName());
		
		TextView tv2=(TextView)convertView.findViewById(R.id.textViewQuantity);
		String strQnt=p.getStrQuantity();
		tv2.setText(strQnt);
		
		TextView tv3=(TextView)convertView.findViewById(R.id.textViewPrice);
		String strPrc=p.getStrPrice();
		tv3.setText(strPrc);
		
		float fltTotal=0;
		if(!(strQnt.equals("")||strQnt.equals(null)||strQnt==""||strQnt==null||strPrc.equals("")||strPrc.equals(null)||strPrc==""||strPrc==null))
		fltTotal=Float.parseFloat(strQnt)*Float.parseFloat(strPrc);
		
		
		
		
		
		TextView tv4=(TextView)convertView.findViewById(R.id.textViewTotal);
		tv4.setText(""+fltTotal);
		
		
		return convertView;
	}

}

package com.oswell.productapp;



import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewProductsActivity extends Activity
{
	ListView lView;
	TextView tv;
	float fltGrandTotal=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewproducts);
		
		tv=(TextView)findViewById(R.id.textViewGT2);
		
		lView=(ListView)findViewById(R.id.listView2);
		
		lView.setAdapter(new MyViewAdapter(this));
		
		getGrandTotal();
		tv.setText(""+fltGrandTotal);
		
		if(ApplicationConstant.AllselectedItems.size()>0)
			{
			
			GridView gridview = (GridView) findViewById(R.id.gridview);
		      gridview.setAdapter(new ImageBiilsAdapter(this));
			}
	
		
	//Toast.makeText(getApplicationContext(), "Total Images selected : "+ApplicationConstant.AllselectedItems.size(), 2000).show();
	}
	
	
	public float getGrandTotal()
	{
		for(int i=0;i<ApplicationConstant.AllProducts.size();i++)
		{
			Product p=(Product)ApplicationConstant.AllProducts.get(i);
			
			String strQnt=p.getStrQuantity();
			String strPrc=p.getStrPrice();
			
			float fltTotal=0;
			if(!(strQnt.equals("")||strQnt.equals(null)||strQnt==""||strQnt==null||strPrc.equals("")||strPrc.equals(null)||strPrc==""||strPrc==null))
			fltTotal=Float.parseFloat(strQnt)*Float.parseFloat(strPrc);
			
			fltGrandTotal=fltGrandTotal+fltTotal;
			
			
		}
		
		return fltGrandTotal;
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
	    if ((keyCode == KeyEvent.KEYCODE_BACK))
	    {
	    	ApplicationConstant.AllProducts.clear();
	    	ApplicationConstant.AllselectedItems.clear();
	        finish();
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	

}

package com.oswell.productapp;

import java.io.File;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageBiilsAdapter extends BaseAdapter
{
	ViewProductsActivity vProductActivity;
	
	ImageBiilsAdapter(ViewProductsActivity vProductActivity)
	{
		this.vProductActivity=vProductActivity;
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return ApplicationConstant.AllselectedItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View contentView, ViewGroup parents) 
	{
		// TODO Auto-generated method stub
		
		ImageView imageView;
	      
	      if (contentView == null) {
	         imageView = new ImageView(vProductActivity);
	         imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
	         imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	         imageView.setPadding(8, 8, 8, 8);
	      } 
	      else 
	      {
	         imageView = (ImageView) contentView;
	      }
	      //imageView.setImageResource(mThumbIds[position]);
	      
	      File file = new File(""+ApplicationConstant.AllselectedItems.get(position));
	    		  Uri uri = Uri.fromFile(file);
	    		  imageView.setImageURI(uri);
	    		  
	    		  
		return imageView;
	}

}

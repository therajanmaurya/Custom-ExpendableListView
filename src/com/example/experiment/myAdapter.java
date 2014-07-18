package com.example.experiment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myAdapter extends BaseExpandableListAdapter {
    private Context context;
    Typeface type ;
    protected LayoutInflater inflater = null;
   static int[] image = {R.drawable.sample_0,R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3};
   static String []parentlist = {"Products","ViewPDF","TODO List","Contacts"}; 
   static String [][]childlist = {{"Products lists \n 1. Books \n 2. Copy \n 3.Table", "Books","Copy"},{"ViewPDF list \n 1.Adobe Reader \n 2. PDF Reader \n 3.All PDF"},{"TODO list"},{"Contacts list"}};
	public myAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return parentlist.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return childlist[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}
	
	 

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.fragment_main, null);
        } 
		ImageView im = (ImageView) convertView.findViewById(R.id.image);
		im.setImageResource(ExpandableListview.images[groupPosition]);
		TextView tv = (TextView) convertView.findViewById(R.id.text);
		type = Typeface.createFromAsset(context.getAssets(), "font/Roboto-Black.ttf");
		tv.setText(parentlist[groupPosition]);
		tv.setPadding(40, 10 , 10 , 10);
		tv.setTextSize(30);
		tv.setTypeface(type);
		
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		type = Typeface.createFromAsset(context.getAssets(), "font/Roboto-Bold.ttf");
		TextView tv = new TextView(context);
		tv.setText(childlist[groupPosition][childPosition]);
		tv.setPadding(30, 10, 10, 10);
		tv.setTextSize(30);
		tv.setTextColor(Color.RED);
		tv.setTypeface(type);
		return tv;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true ;
	}

}

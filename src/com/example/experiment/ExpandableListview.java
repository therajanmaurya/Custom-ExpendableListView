package com.example.experiment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class ExpandableListview extends Activity{
    ExpandableListView exv;
    public static final Integer[] images = {
        R.drawable.sample_0,
        R.drawable.sample_1,
        R.drawable.sample_2,
        R.drawable.sample_3

    };
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.expand);
		exv = (ExpandableListView)findViewById(R.id.expandable);
		exv.setAdapter(new myAdapter(this));
		
		exv.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
		        String itemclick = myAdapter.childlist[groupPosition][childPosition];
		        Toast.makeText(ExpandableListview.this,itemclick + "   Is  clicked", Toast.LENGTH_LONG).show();
				return false;
			}
		});
		
	
	}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	

}


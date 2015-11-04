package com.example.slidingmenu.view;

import com.example.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class LeftMenuMain extends Activity {
	
	RelativeLayout login_top_relativelayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.left_menu);
		
		login_top_relativelayout=(RelativeLayout) findViewById(R.id.login_top);
	}

}

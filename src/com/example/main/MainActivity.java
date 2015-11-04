package com.example.main;

import java.util.ArrayList;
import java.util.List;

import com.example.k.pupowindows.PupoWindowsActivity;
import com.example.register_login.LoginAction;
import com.example.register_login.RegisterAction;
import com.example.search.Search;
import com.example.slidingmenu.view.SlidingMenu;
import com.example.classify.FragmentAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener
{

	private SlidingMenu mLeftMenu ; 
	ImageButton imageSearch;
	ImageButton image_k;
	TextView newuser_register;
	Button loginButton;
	



	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		initView();
		initEvents();
		
	}
	
	private void initEvents() {
		// TODO Auto-generated method stub
		imageSearch.setOnClickListener(this);
		image_k.setOnClickListener(this);
		newuser_register.setOnClickListener(this);
		loginButton.setOnClickListener(this);
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		mLeftMenu = (SlidingMenu) findViewById(R.id.id_menu);
		imageSearch = (ImageButton) findViewById(R.id.image_search);
		image_k=(ImageButton) findViewById(R.id.image_k);
		newuser_register=(TextView) findViewById(R.id.newuser_register);
		loginButton=(Button) findViewById(R.id.button_login);


	}

	public void toggleMenu(View view)
	{
		mLeftMenu.toggle();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		switch (v.getId()) {
		case R.id.image_search:
			intent.setClass(this, Search.class);
			startActivity(intent);
			break;
		case R.id.image_k:
			intent.setClass(this, PupoWindowsActivity.class);
			startActivity(intent);
			break;
		case R.id.newuser_register:
			intent.setClass(this,RegisterAction.class);
			startActivity(intent);
			break;
		case R.id.image_cla:
			break;
		case R.id.button_login:
			intent.setClass(this,LoginAction.class);
			startActivity(intent);;
		}
	}
}

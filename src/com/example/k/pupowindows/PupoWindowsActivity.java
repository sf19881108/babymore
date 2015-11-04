package com.example.k.pupowindows;


import com.example.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PupoWindowsActivity extends Activity implements OnClickListener {

	RelativeLayout relativeLayout;
	TextView sing_oratorio;
	TextView sing_accompany;
	Button k_cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.k_pupowindow);

	}

	private void initEvents() {
		// TODO Auto-generated method stub
		relativeLayout.setOnClickListener(this);
		sing_accompany.setOnClickListener(this);
		sing_oratorio.setOnClickListener(this);
		k_cancel.setOnClickListener(this);

	}

	private void initView() {
		// TODO Auto-generated method stub
		relativeLayout = (RelativeLayout) findViewById(R.id.k_relativeLayout);
		sing_accompany=(TextView) findViewById(R.id.sing_accompany);
		sing_oratorio=(TextView) findViewById(R.id.sing_oratorio);
		k_cancel=(Button) findViewById(R.id.k_cancel);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.k_relativeLayout:
			
			break;
		case R.id.k_cancel:
			finish();
			break;
		case R.id.sing_accompany:
		
			break;
		case R.id.sing_oratorio:
			break;

		default:
			break;
		}

	}

}

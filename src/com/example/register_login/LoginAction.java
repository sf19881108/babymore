package com.example.register_login;

import com.example.main.MainActivity;
import com.example.main.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginAction extends Activity implements OnClickListener {
	EditText login_username;
	EditText login_password;
	Button login_button;
	TextView loginSuccessUsername;
	
	private static final String TAG="LoginAction";
	private UserDataManager mUserDataManager;

	private View loginTop, loginSuccessTop;

	RegisterAction rAction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);

		login_username = (EditText) findViewById(R.id.login_username);
		login_password = (EditText) findViewById(R.id.login_password);
		login_button = (Button) findViewById(R.id.login_button);
		loginSuccessUsername = (TextView) findViewById(R.id.login_success_username);
		loginTop = findViewById(R.id.login_top);
		loginSuccessTop = findViewById(R.id.login_success_top);

		login_button.setOnClickListener(this);

		rAction = new RegisterAction();

		if (mUserDataManager == null) {
			mUserDataManager = new UserDataManager(this);
			mUserDataManager.openDataBase();
		}

	}
	
	public boolean isUserNameAndPwdValid() {
		if (login_username.getText().toString().trim().equals("")) {
			Toast.makeText(this, getString(R.string.userName_empty),
					Toast.LENGTH_SHORT).show();
			return false;
		} else if (login_password.getText().toString().trim().equals("")) {
			Toast.makeText(this, getString(R.string.pwd_empty),
					Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_button:
           Log.i(TAG, "¿ªÊ¼µÇÂ¼ÁË");
			login();

			break;

		}

	}

	public void login() {
		
			if (isUserNameAndPwdValid()) {
				
					String userName = login_username.getText().toString().trim();
					String userPwd = login_password.getText().toString().trim();
					int result = mUserDataManager.findUserByNameAndPwd(userName,
							userPwd);
					if (result == 1) {
						// login success
						System.out.println(loginTop);

						loginTop.setVisibility(View.GONE);
						loginSuccessTop.setVisibility(View.VISIBLE);
						loginSuccessUsername.setText(getString(
								R.string.user_login_sucess, userName));
						Toast.makeText(this, getString(R.string.user_login_sucess),
								Toast.LENGTH_SHORT).show();
						Intent intent = new Intent(this, MainActivity.class);
						startActivity(intent);
					} else if (result == 0) {
						// login failed,user does't exist
						Toast.makeText(this, getString(R.string.login_fail),
								Toast.LENGTH_SHORT).show();
					}
				
				
			}

	}

	@Override
	protected void onResume() {
		if (mUserDataManager == null) {
			mUserDataManager = new UserDataManager(this);
			mUserDataManager.openDataBase();
		}
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		if (mUserDataManager != null) {
			mUserDataManager.closeDataBase();
			mUserDataManager = null;
		}
		super.onPause();
	}

}

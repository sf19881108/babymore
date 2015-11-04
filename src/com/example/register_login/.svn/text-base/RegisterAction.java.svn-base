package com.example.register_login;

import com.example.main.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.register_login.UserDataManager;

public class RegisterAction extends Activity implements OnClickListener {

	Button registerSuer;
	EditText registerUsername;
	EditText registerPassword;
	private UserDataManager mUserDataManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register);

		registerSuer = (Button) findViewById(R.id.register_sure);
		registerUsername = (EditText) findViewById(R.id.register_username);
		registerPassword = (EditText) findViewById(R.id.register_password);

		registerSuer.setOnClickListener(this);

		if (mUserDataManager == null) {
			mUserDataManager = new UserDataManager(this);
			mUserDataManager.openDataBase();
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.register_sure:
			register();
			break;

		default:
			break;
		}
	}

	public boolean isUserNameAndPwdValid() {// 判断用户名，密码和校验密码是否为空
		if (registerUsername.getText().toString().trim().equals("")) {
			Toast.makeText(this, getString(R.string.userName_empty),
					Toast.LENGTH_SHORT).show();
			return false;
		} else if (registerPassword.getText().toString().trim().equals("")) {
			Toast.makeText(this, getString(R.string.pwd_empty),
					Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	public void register() {

		String userName = registerUsername.getText().toString().trim();
		String userPwd = registerPassword.getText().toString().trim();
		if (isUserNameAndPwdValid()) {// 判定注册用户是否已经被注册了
			int count = mUserDataManager.findUserByName(userName);
			if (count > 0) {
				Toast.makeText(this,
						getString(R.string.username_already_exist),
						Toast.LENGTH_SHORT).show();
				return;
			}
		}

		UserData mUser = new UserData(userName, userPwd);
		mUserDataManager.openDataBase();
		long flag = mUserDataManager.insertUserData(mUser);
		if (flag == -1) {
			Toast.makeText(this, getString(R.string.register_fail),
					Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, getString(R.string.register_success),
					Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(this, LoginAction.class);
			startActivity(intent);

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

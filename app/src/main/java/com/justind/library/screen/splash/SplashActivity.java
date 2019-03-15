package com.justind.library.screen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.justind.library.screen.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SystemClock.sleep(1000);
    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
    startActivity(intent);
    finish();
  }
}

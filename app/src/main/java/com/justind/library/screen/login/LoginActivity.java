package com.justind.library.screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.justind.codetotop.base.pattern_mvp.activity.BaseActivity;
import com.justind.library.R;
import com.justind.library.screen.home.HomeActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {
  @BindView(R.id.btnNextToHome)
  Button mBtnNextToHome;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  protected int getLayoutResourceID() {
    return R.layout.activity_login;
  }

  @Override
  public LoginContract.Presenter createPresenter() {
    return new LoginPresenter();
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @OnClick(R.id.btnNextToHome)
  void openHomeActivity() {
    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
    startActivity(intent);
  }
}

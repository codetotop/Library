package com.justind.library.screen.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.justind.codetotop.base.pattern_mvp.activity.BaseActivity;
import com.justind.library.R;

public class HomeActivity extends BaseActivity<HomeContract.Presenter> implements HomeContract.View {


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  protected int getLayoutResourceID() {
    return R.layout.activity_home;
  }

  @Override
  public HomeContract.Presenter createPresenter() {
    return new HomePresenter();
  }

  @Override
  protected void initView() {

  }

  @Override
  protected void onResume() {
    super.onResume();
  }
}

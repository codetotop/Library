package com.justind.codetotop.base.pattern_viper.activity;

import android.content.Context;

public abstract class BaseActivityInteractor<P extends BaseActivityContract.Presenter> implements BaseActivityContract.Interactor<P> {
  P mPresenter;

  @Override
  public Context getContext() {
    return mPresenter.getContext();
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }

  @Override
  public void setPresenter(P presenter) {
    mPresenter = presenter;
  }

}

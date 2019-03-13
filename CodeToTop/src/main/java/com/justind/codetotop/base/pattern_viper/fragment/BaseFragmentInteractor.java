package com.justind.codetotop.base.pattern_viper.fragment;

import android.content.Context;

public abstract class BaseFragmentInteractor<P extends BaseFragmentContract.Presenter>
        implements BaseFragmentContract.Interactor<P> {

  P mPresenter;

  @Override
  public void setPresenter(P presenter) {
    mPresenter = presenter;
  }

  @Override
  public P getPresenter() {
    return mPresenter;
  }

  @Override
  public Context getContext() {
    return mPresenter.getContext();
  }
}

package com.justind.codetotop.base.pattern_mvp.activity;

import android.content.Context;

public abstract class BaseActivityPresenter<V extends BaseActivityContract.View> implements BaseActivityContract.Presenter<V> {
  V mView;

  @Override
  public V getView() {
    return mView;
  }

  @Override
  public void setView(V view) {
    this.mView = view;
  }

  @Override
  public Context getContext() {
    return (Context) mView;
  }
}

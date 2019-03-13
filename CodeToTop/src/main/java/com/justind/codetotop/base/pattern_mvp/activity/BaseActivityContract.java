package com.justind.codetotop.base.pattern_mvp.activity;

import android.content.Context;

public interface BaseActivityContract {

  interface View<P extends Presenter> {
    P createPresenter();

    P getPresenter();
  }

  interface Presenter<V extends View> {
    V getView();

    void setView(V view);

    Context getContext();
  }
}

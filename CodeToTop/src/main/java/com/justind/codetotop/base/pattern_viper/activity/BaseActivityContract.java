package com.justind.codetotop.base.pattern_viper.activity;

import android.content.Context;

public interface BaseActivityContract {
  interface View<P extends Presenter> {
    P createPresenter();

    P getPresenter();

    void showError(int code, String message);
  }

  interface Presenter<V extends View, I extends Interactor> {
    V getView();

    /*Attack View*/
    void setView(V view);

    I createInteractor();

    I getInteractor();

    Context getContext();

    void handleError(Throwable throwable);
  }

  interface Interactor<P extends Presenter> {
    P getPresenter();

    void setPresenter(P presenter);

    Context getContext();
  }
}

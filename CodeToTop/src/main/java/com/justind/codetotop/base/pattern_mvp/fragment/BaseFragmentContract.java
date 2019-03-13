package com.justind.codetotop.base.pattern_mvp.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

public interface BaseFragmentContract {
  interface View<P extends Presenter> {
    P getPresenter();

    void setPresenter(P presenter);

    Context getContext();

    void showError();
  }

  interface Presenter<V extends View> {
    V createView();

    V getView();

    Fragment getFragment();

    Context getContext();
  }
}

package com.justind.library.screen.login;

import com.justind.codetotop.base.pattern_mvp.activity.BaseActivityContract;

public interface LoginContract {
  interface View extends BaseActivityContract.View<Presenter> {

  }

  interface Presenter extends BaseActivityContract.Presenter<View> {

  }
}

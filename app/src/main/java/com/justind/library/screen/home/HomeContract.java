package com.justind.library.screen.home;


import com.justind.codetotop.base.pattern_mvp.activity.BaseActivityContract;

public interface HomeContract {
  interface View extends BaseActivityContract.View<Presenter> {

  }

  interface Presenter extends BaseActivityContract.Presenter<View> {


  }

}

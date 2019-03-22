package com.justind.library;

import android.support.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.justind.library.common.CacheHelper;

public class LibraryApplication extends MultiDexApplication {

  @Override
  public void onCreate() {
    super.onCreate();
    Fresco.initialize(this);
    CacheHelper.getInstance().init(this);
  }
}

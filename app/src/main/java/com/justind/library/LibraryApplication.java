package com.justind.library;

import android.support.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;

public class LibraryApplication extends MultiDexApplication {

  @Override
  public void onCreate() {
    super.onCreate();
    Fresco.initialize(this);
  }
}

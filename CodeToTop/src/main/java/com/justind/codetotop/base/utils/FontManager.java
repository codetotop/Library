package com.justind.codetotop.base.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by dong on 30/10/2017.
 */

public class FontManager {
  private static FontManager sInstance;
  private HashMap<String, Typeface> fonts;

  private FontManager() {
    fonts = new HashMap<>();
  }

  public static FontManager getInstance() {
    if (sInstance == null) {
      synchronized (FontManager.class) {
        if (sInstance == null) {
          sInstance = new FontManager();
        }
      }
    }
    return sInstance;
  }

  public Typeface getFont(Context context, String fontPath) {
    if (!fonts.containsKey(fontPath)) {
      Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontPath);
      fonts.put(fontPath, typeface);
    }
    return fonts.get(fontPath);
  }
}

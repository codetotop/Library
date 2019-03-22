package com.justind.library.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.justind.codetotop.base.utils.JsonHelper;
import com.justind.library.pojo.model.Question;

public class CacheHelper {

  private static final String PREF_NAME = "com.justind.library.common";
  private static final String KEY_QUESTION_JSON = "KEY_QUESTION_JSON";
  private static CacheHelper sInstance;
  private SharedPreferences mSharedPreferences;

  private CacheHelper() {
  }

  public static CacheHelper getInstance() {
    if (sInstance == null) {
      synchronized (CacheHelper.class) {
        if (sInstance == null)
          sInstance = new CacheHelper();
      }
    }
    return sInstance;
  }

  public void init(Context context) {
    mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
  }

  /*Use SharePreferences*/
  public void saveQuestionJson(Question question) {
    mSharedPreferences.edit().putString(KEY_QUESTION_JSON, JsonHelper.getGson().toJson(question)).apply();
  }

  public Question getQuestionObject() {
    if (mSharedPreferences.contains(KEY_QUESTION_JSON)) {
      String strQuestionJson = mSharedPreferences.getString(KEY_QUESTION_JSON, "");
      if (JsonHelper.isJson(strQuestionJson))
        return JsonHelper.getGson().fromJson(strQuestionJson, Question.class);
    }
    return null;
  }
}

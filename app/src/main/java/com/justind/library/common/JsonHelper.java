package com.justind.library.common;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DungNB 10/20/17.
 */

public class JsonHelper {
  private static Gson sGson;

  public synchronized static Gson getGson() {
    if (sGson == null) {
      sGson = new Gson();
    }
    return sGson;
  }

  public synchronized static boolean isJson(String data) {
    if (data == null || "".equals(data)) return false;
    try {
      new JSONObject(data);
    } catch (JSONException e) {
      try {
        new JSONArray(data);
      } catch (JSONException e1) {
        return false;
      }
    }
    return true;
  }
}

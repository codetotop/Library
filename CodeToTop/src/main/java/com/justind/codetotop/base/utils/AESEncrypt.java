package com.justind.codetotop.base.utils;

import android.util.Base64;
import android.util.Log;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncrypt {
  private static final String key = "aesEncryptionKey";
  private static final String initVector = "encryptionIntVec";
  private static final String TAG = "Gabriel";

  public static String encrypt(String value) {
    try {
      IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
      SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

      byte[] encrypted = cipher.doFinal(value.getBytes());
      System.out.println("encrypted string: "
              + Base64.encodeToString(encrypted, Base64.DEFAULT));
      Log.e(TAG, "ENCRIPTED: " + Base64.encodeToString(encrypted, Base64.DEFAULT));
      return Base64.encodeToString(encrypted, Base64.DEFAULT);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  public static String decrypt(String encrypted) {
    try {
      IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
      SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

      byte[] original = cipher.doFinal(Base64.decode(encrypted, Base64.DEFAULT));
      Log.e(TAG, "DECRIPTED: " + new String(original));
      return new String(original);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }
}

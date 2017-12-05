package com.utils;

public class HttpSenderUtils
{
  public static String createRandomVcode()
  {
    String vcode = "";
    for (int i = 0; i < 6; i++) {
      vcode = vcode + (int)(Math.random() * 9.0D);
    }
    System.out.println(vcode);
    
    return vcode;
  }
}

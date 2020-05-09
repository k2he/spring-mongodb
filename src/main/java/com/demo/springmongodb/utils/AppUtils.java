package com.demo.springmongodb.utils;

import java.util.List;

public class AppUtils {

  public static String replaceWithParam(String text, String param) {
    return param != null ? text.replaceFirst("\\{.*?\\}", param) : text;
  }
  
  public static String replaceUrlwithParams(String text, List<String> params) {
    if (params == null) {
      return text;
    }
    
    String result = text;
    for (String param: params) {
      result = result.replaceFirst("\\{.*?\\}", param);
    }
    return result;
  }
}

package com.zr.api;

import android.util.Log;

public class Helper {
    public static int log(Class clazz,int value){
        String canonicalName =clazz.getCanonicalName();
        Log.i("=====",value+"====="+canonicalName);
        return value;
    }
}
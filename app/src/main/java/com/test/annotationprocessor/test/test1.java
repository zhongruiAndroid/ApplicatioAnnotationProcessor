package com.test.annotationprocessor.test;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.test.annotationprocessor.test2.TestParent;
import com.zr.annotation.AppLifeCycle;
import com.zr.api.AppLifecycleListener;



@AppLifeCycle("app")
public class test1 extends TestParent implements AppLifecycleListener {
    public static final String a = "a";

    @Override
    public int getPriority() {
        return 13;
    }

    @Override
    public void onCreate(Application application) {
    }

    @Override
    public void attachBaseContext(Application application, Context base) {

    }

    @Override
    public void onConfigurationChanged(Application application, Configuration newConfig) {

    }

    @Override
    public void onLowMemory(Application application) {

    }

    @Override
    public void onTerminate(Application application) {

    }

    @Override
    public void onTrimMemory(Application application, int level) {

    }
}
package com.test.annotationprocessor.test2;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.zr.annotation.AppLifeCycle;
import com.zr.api.AppLifecycleListener;


@AppLifeCycle("app")
public class Test10 implements AppLifecycleListener {
    @Override
    public int getPriority() {
        return 9;
    }

    @Override
    public void onCreate(Application application) {
        Log.i("=====","onCreate=====9");
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
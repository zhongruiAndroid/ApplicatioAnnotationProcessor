package com.test.annotationprocessor.test.test11;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.test.annotationprocessor.BuildConfig;
import com.zr.annotation.AppLifeCycle;
import com.zr.api.AppLifecycleListener;



@AppLifeCycle(BuildConfig.moduleName)
public class Test3 implements AppLifecycleListener {
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public void onCreate(Application application) {
        Log.i("=====","onCreate=====1");
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
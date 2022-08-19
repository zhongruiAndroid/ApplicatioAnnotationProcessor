package com.test.annotationprocessor.test;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.test.annotationprocessor.test2.Test7;
import com.zr.annotation.AppLifeCycle;
import com.zr.api.AppLifecycleListener;

public class Test2 implements AppLifecycleListener {
    private Test7 test2;

    public Test2() {
        this.test2 = new Test7();
    }

    @Override
    public int getPriority() {
        return test2.getPriority();
    }

    @Override
    public void onCreate(Application application) {
        test2.onCreate(application);
    }

    @Override
    public void attachBaseContext(Application application, Context base) {
        test2.attachBaseContext(application, base);
    }

    @Override
    public void onConfigurationChanged(Application application, Configuration newConfig) {
        test2.onConfigurationChanged(application, newConfig);
    }

    @Override
    public void onLowMemory(Application application) {
        test2.onLowMemory(application);
    }

    @Override
    public void onTerminate(Application application) {
        test2.onTerminate(application);
    }

    @Override
    public void onTrimMemory(Application application, int level) {
        test2.onTrimMemory(application, level);
    }
}
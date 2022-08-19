package com.test.annotationprocessor.test.test11;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.zr.annotation.AppLifeCycle;
import com.zr.api.AppLifecycleListener;
import com.zr.api.Helper;

@AppLifeCycle("app")
public class Test4 implements AppLifecycleListener {
    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public void onCreate(Application application) {
        Helper.log(getClass(),0);
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
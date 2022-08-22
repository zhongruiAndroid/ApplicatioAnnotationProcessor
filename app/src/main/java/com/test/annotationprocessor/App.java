package com.test.annotationprocessor;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.zr.api.AppLifecycleHelper;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppLifecycleHelper.setModuleName(BuildConfig.moduleName);
        AppLifecycleHelper.get().onCreate(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        AppLifecycleHelper.get().onConfigurationChanged(this, newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        AppLifecycleHelper.get().onLowMemory(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        AppLifecycleHelper.get().onTerminate(this);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        AppLifecycleHelper.get().onTrimMemory(this, level);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        AppLifecycleHelper.get().attachBaseContext(this, base);
    }
}
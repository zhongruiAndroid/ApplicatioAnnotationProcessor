package com.test.module_b.testa;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.zr.annotation.AppLifeCycle;
import com.zr.api.AppLifecycleListener;
import com.zr.api.Helper;

@AppLifeCycle("module_b")
public class Testb2 implements AppLifecycleListener {
    @Override
    public int getPriority() {
        return 7;
    }

    @Override
    public void onCreate(Application application) {
        Helper.log(getClass(),7);
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
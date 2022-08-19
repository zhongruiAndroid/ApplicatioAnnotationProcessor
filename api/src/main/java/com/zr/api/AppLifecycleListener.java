package com.zr.api;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public interface AppLifecycleListener {
    int getPriority();

    void onCreate(Application application);

    void attachBaseContext(Application application, Context base);

    void onConfigurationChanged(Application application, Configuration newConfig);

    void onLowMemory(Application application);

    void onTerminate(Application application);

    void onTrimMemory(Application application, int level);
}
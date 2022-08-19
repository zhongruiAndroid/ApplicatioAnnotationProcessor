package com.zr.api;


import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppLifecycleHelper {
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.zr.lifecycle.proxy";
    public static final String PROXY_CLASS_SIMPLE_NAME = "AppLifecycle$$Application";

    /**********************************************************/
    private static AppLifecycleHelper singleObj;

    public static AppLifecycleHelper get() {
        if (singleObj == null) {
            synchronized (AppLifecycleHelper.class) {
                if (singleObj == null) {
                    singleObj = new AppLifecycleHelper();
                }
            }
        }
        return singleObj;
    }

    /**********************************************************/
    private List<AppLifecycleListener> lifecycleListeners = new ArrayList<>();

    private AppLifecycleHelper() {

        long currentTimeMillis1 = System.currentTimeMillis();

        lifecycleListeners.clear();

        String str = BuildConfig.moduleName;
        if (str == null || str.length() <= 0) {
            return;
        }
        String[] split = str.split("\\|");
        int length = split.length;

        String PROXY_CLASS_NAME;
        for (int i = 0; i < length; i++) {
            String moduleName = split[i];
            int startIndex = 0;
            boolean flag = true;

            PROXY_CLASS_NAME = PROXY_CLASS_PACKAGE_NAME + "." + moduleName + "." + PROXY_CLASS_SIMPLE_NAME;
            while (flag) {
                try {
                    Class<?> newClass = Class.forName(PROXY_CLASS_NAME + startIndex);
                    lifecycleListeners.add((AppLifecycleListener) newClass.newInstance());
                    startIndex += 1;
                } catch (Exception e) {
                    e.printStackTrace();
                    flag = false;
                }
            }
        }

        Collections.sort(lifecycleListeners, new Comparator<AppLifecycleListener>() {
            @Override
            public int compare(AppLifecycleListener o1, AppLifecycleListener o2) {
                int temp = o2.getPriority() - o1.getPriority();
                if (temp > 0) {
                    return -1;
                }
                if (temp < 0) {
                    return 1;
                }
                return 0;
            }
        });


        long currentTimeMillis2 = System.currentTimeMillis();
        Log.i("onCreate", (currentTimeMillis2 - currentTimeMillis1) + "ms");
    }

    public void onCreate(Application application) {
        for (AppLifecycleListener item : lifecycleListeners) {
            item.onCreate(application);
        }
    }

    public void attachBaseContext(Application application, Context base) {
        for (AppLifecycleListener item : lifecycleListeners) {
            item.attachBaseContext(application, base);
        }
    }

    public void onConfigurationChanged(Application application, Configuration newConfig) {
        for (AppLifecycleListener item : lifecycleListeners) {
            item.onConfigurationChanged(application, newConfig);
        }
    }

    public void onLowMemory(Application application) {
        for (AppLifecycleListener item : lifecycleListeners) {
            item.onLowMemory(application);
        }
    }

    public void onTerminate(Application application) {
        for (AppLifecycleListener item : lifecycleListeners) {
            item.onTerminate(application);
        }
    }

    public void onTrimMemory(Application application, int level) {
        for (AppLifecycleListener item : lifecycleListeners) {
            item.onTrimMemory(application, level);
        }
    }
}
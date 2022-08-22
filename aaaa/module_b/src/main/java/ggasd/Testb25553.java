package ggasd;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.zr.annotation.AppLifeCycle;
import com.zr.api.AppLifecycleListener;


@AppLifeCycle("module_b")
public class Testb25553 implements AppLifecycleListener {
    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public void onCreate(Application application) {
        Log.i("=====","onCreate=====0");
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
package com.test.module_b;


import android.app.Activity;
import android.os.Bundle;

import com.zr.annotation.AppLifeCycle;
import com.zr.api.BuildConfig;

@AppLifeCycle("module_b")
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
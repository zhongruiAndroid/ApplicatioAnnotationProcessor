package com.test.annotationprocessor;

import android.os.Bundle;
import android.util.Log;



import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ARouter.init(getApplication());
        Log.i("=====","====="+ BuildConfig.moduleName);
    }
}
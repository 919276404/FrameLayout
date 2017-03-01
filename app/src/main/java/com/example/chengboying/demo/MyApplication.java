package com.example.chengboying.demo;

import android.app.Application;
import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by chengboying on 2017/2/10.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);


    }
}

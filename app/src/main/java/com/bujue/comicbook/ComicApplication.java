package com.bujue.comicbook;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * @author bujue
 * @date 16/4/21
 */
public class ComicApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}

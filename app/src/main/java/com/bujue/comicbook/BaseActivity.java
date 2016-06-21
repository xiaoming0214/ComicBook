package com.bujue.comicbook;

import android.support.v7.app.AppCompatActivity;

/**
 * 基类
 * @author bujue
 * @date 16/4/15
 */
public class BaseActivity extends AppCompatActivity {


    /**
     * 根据Id查找View
     * @param id
     * @param <T>
     * @return
     */
    protected <T> T findView(int id){
        return (T) findViewById(id);
    }
}

package com.bujue.comicbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 漫画预览
 * @author bujue
 * @date 16/4/15
 */
public class ComicPreviewActivity extends BaseActivity {

    @Bind(R.id.comic_preview_web)
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comic_preview);

        Intent intent = getIntent();
        if(intent == null){
            return;
        }
        String comicUrl = intent.getStringExtra("COMIC_URL");
        if(TextUtils.isEmpty(comicUrl)){
            return;
        }

        ButterKnife.bind(this);
        webView.loadUrl(comicUrl);
        //支持javascript
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        //扩大比例的缩放
        webView.getSettings().setUseWideViewPort(true);
        //自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);
    }
}

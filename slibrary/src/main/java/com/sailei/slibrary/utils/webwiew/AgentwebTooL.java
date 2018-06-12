package com.sailei.slibrary.utils.webwiew;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/**
 * @author 韩晓强
 * @date 2018/5/30
 * @describe webwiew的封装 基于AgentWeb  具体使用请参考https://github.com/Justson/AgentWeb
 */
public class AgentwebTooL {
    private static volatile AgentwebTooL instance;
    private AgentWeb mAgentWeb;

    private AgentwebTooL() {
    }

    public static AgentwebTooL getInstance() {
        if (instance == null) {
            synchronized (AgentwebTooL.class) {
                if (instance == null) {
                    instance = new AgentwebTooL();
                }
            }
        }
        return instance;
    }

    public void init(@NonNull Activity activity, @NonNull LinearLayout linearLayout, @NonNull String url) {
        init(activity, linearLayout, url, null);
    }

    public void init(@NonNull Fragment fragment, @NonNull LinearLayout linearLayout, @NonNull String url) {
        init(fragment, linearLayout, url, null);
    }

    public void init(@NonNull Activity activity, @NonNull LinearLayout linearLayout, @NonNull String url, @Nullable WebViewClient webViewClient) {
        init(activity, linearLayout, url, webViewClient, null);
    }

    public void init(@NonNull Fragment fragment, @NonNull LinearLayout linearLayout, @NonNull String url, @Nullable WebViewClient webViewClient) {
        init(fragment, linearLayout, url, webViewClient, null);
    }

    public void init(@NonNull Activity activity, @NonNull LinearLayout linearLayout, @NonNull String url, @Nullable WebViewClient webViewClient, @Nullable WebChromeClient webChromeClient) {

            mAgentWeb = AgentWeb.with(activity)
                    .setAgentWebParent(linearLayout, new LinearLayout.LayoutParams(-1, -1))
                    .useDefaultIndicator()
                    .setWebViewClient(webViewClient)
                    .setWebChromeClient(webChromeClient)
                    .createAgentWeb()
                    .ready()
                    .go(url);

    }

    public void init(@NonNull Fragment fragment, @NonNull LinearLayout linearLayout, @NonNull String url, @Nullable WebViewClient webViewClient, @Nullable WebChromeClient webChromeClient) {
        mAgentWeb = AgentWeb.with(fragment)
                .setAgentWebParent(linearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebViewClient(webViewClient)
                .setWebChromeClient(webChromeClient)
                .createAgentWeb()
                .ready()
                .go(url);
    }

    public void onPause() {
        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onPause();
        }
    }

    public WebView getWebView() {
        if (mAgentWeb != null) {
            return mAgentWeb.getWebCreator().getWebView();
        }
        return null;
    }

    public void onResume() {
        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onResume();
        }
    }

    public void onDestroy() {
        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onDestroy();
        }
    }

    public void onDestroyView() {
        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onDestroy();
        }
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mAgentWeb != null) {
            return mAgentWeb.handleKeyEvent(keyCode, event);
        }
        return false;
    }
}

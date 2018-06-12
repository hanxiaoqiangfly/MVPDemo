package com.sailei.slibrary.utils.toast;

import android.content.Context;
import android.widget.Toast;

import com.sailei.slibrary.SL;

/**
 * @author 韩晓强
 * @date 2018/5/29
 * @describe Toast工具类的简单封装
 */
public class ToastTool {
    private static final Object lock = new Object();
    private static volatile ToastTool instance;
    private Toast toast;

    private ToastTool() {
    }

    public static ToastTool getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ToastTool();
                }
            }
        }
        return instance;
    }

    public void showShortToast(String msg) {
        Context appContext = SL.app().getApplicationContext();
        showShortToast(appContext, msg);
    }

    private void showShortToast(Context mContext, String msg) {

        if (toast == null) {
            toast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    public void showShortToast(int stringID) {
        Context appContext = SL.app().getApplicationContext();
        showShortToast(appContext, appContext.getString(stringID));
    }

    public void showLongToast(String msg) {
        Context appContext = SL.app().getApplicationContext();
        showLongToast(appContext, msg);
    }

    private void showLongToast(Context mContext, String msg) {
        if (toast == null) {
            toast = Toast.makeText(mContext, msg, Toast.LENGTH_LONG);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    public void showLongToast(int stringID) {
        Context appContext = SL.app().getApplicationContext();
        showLongToast(appContext, appContext.getString(stringID));
    }
}

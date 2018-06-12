package com.sailei.slibrary.utils.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * @author 韩晓强
 * @date 2018/5/30
 * @describe AppName  VersionName
 */
public class AppTool {
    private static volatile AppTool instance;

    private AppTool() {
    }

    /**
     * 单例模式之双重检查锁定
     */
    public static AppTool getInstance() {
        if (instance == null) {
            synchronized (AppTool.class) {
                if (instance == null) {
                    instance = new AppTool();
                }
            }
        }
        return instance;
    }

    /**
     * 获取应用程序名称
     */
    public  String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称
     */
    public  String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 当前应用的版本号
     * @param context
     * @return
     */
    public  int getVersionCode(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;

        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

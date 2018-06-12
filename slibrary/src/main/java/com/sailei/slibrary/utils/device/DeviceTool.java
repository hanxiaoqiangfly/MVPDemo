package com.sailei.slibrary.utils.device;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.sailei.slibrary.SL;

/**
 * @author 韩晓强
 * @date 2018/5/29
 * @describe 获取手机设备信息
 */
public class DeviceTool {
    private static volatile DeviceTool instance = new DeviceTool();

    private DeviceTool() {
    }

    public static DeviceTool getInstance() {
        return instance;
    }

    /**
     * 获取手机IMEI号
     * add <uses-permission android:name="android.permission.READ_PHONE_STATE" /> in AndroidManifest.xml
     *
     * @param context
     * @return
     */
    /**
     * 获取设备的IMEI
     *
     * @param context
     * @return
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    public  String getDeviceIdIMEI(Context context) {
        String id;
        //android.telephony.TelephonyManager
        TelephonyManager mTelephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (mTelephony.getDeviceId() != null) {
            id = mTelephony.getDeviceId();
        } else {
            //android.provider.Settings;
            id = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return id;
    }

    /**
     * 获取手机厂商
     *
     * @return
     */
    public String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public String getDeviceModel() {
        return Build.MODEL;
    }

    /**
     * 获取手机系统版本号
     *
     * @return
     */
    public String getDeviceSystemVersion() {
        return Build.VERSION.RELEASE;
    }
    /**
     * 获取手机号
     *
     * @param context
     * @return
     */
    @SuppressLint("MissingPermission")
    public  String getLine1Number(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getLine1Number();
    }

    /**
     * 获取屏幕的宽
     *
     * @param context
     * @return
     */
    public int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕的高度
     *
     * @param context
     * @return
     */
    public int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
    /**
     * 得到设备屏幕的宽度
     */
    public  int getScreenWidths(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 得到设备屏幕的高度
     */
    public  int getScreenHeights(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
    /**
     * 状态栏高度
     * 状态栏就是屏幕顶部显示时间，电池，wifi 等信息的栏目。
     * 方法一：系统提供了一个Resource类，通过这个类可以获取资源文件，借此可以获取 到status_bar_height 。
     *
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        Resources resources = SL.app().getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 标题栏高度
     *
     * @param activity
     */
    public static void getTitleBarHeight(Activity activity) {
        Rect outRect1 = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect1);

        int viewTop = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();   //要用这种方法
        int titleBarH = viewTop - outRect1.top;

        Log.e("ScreenTool", "标题栏高度-计算:" + titleBarH);
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     *
     * @param activity
     * @return
     */
    public Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;

    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     *
     * @param activity
     * @return
     */
    public Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;

        int width = getScreenWidth(activity);
        int height = getScreenHeight(activity);
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return bp;

    }
}

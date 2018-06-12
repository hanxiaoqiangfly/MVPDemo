package com.sailei.slibrary;

import android.app.Application;

import com.sailei.slibrary.utils.activity.ActivityManager;
import com.sailei.slibrary.utils.app.AppTool;
import com.sailei.slibrary.utils.compress.CompressHelperTool;
import com.sailei.slibrary.utils.compress.LuBanCompressTool;
import com.sailei.slibrary.utils.density.DensityTool;
import com.sailei.slibrary.utils.device.DeviceTool;
import com.sailei.slibrary.utils.keyboard.KeyBoardTool;
import com.sailei.slibrary.utils.log.LogTool;
import com.sailei.slibrary.utils.network.NetworkTool;
import com.sailei.slibrary.utils.pickerview.PickerViewTool;
import com.sailei.slibrary.utils.pwd.ShowHidePwdTool;
import com.sailei.slibrary.utils.reg.RegTool;
import com.sailei.slibrary.utils.sp.SpTool;
import com.sailei.slibrary.utils.time.TimeTool;
import com.sailei.slibrary.utils.toast.ToastTool;
import com.sailei.slibrary.utils.update.UpdateTool;
import com.sailei.slibrary.utils.webwiew.AgentwebTooL;

/**
 * @author 韩晓强
 * @date 2018/5/29
 * @describe 所有工具的统一管理类 调用方式  eg： SL.toast().showToast("fdsfdf");
 */
public class SL {
    private static Application mApp;
    private static ToastTool mToast;
    private static LogTool mLog;
    private static SpTool mSp;
    private static DensityTool mDensity;
    private static NetworkTool mNetwork;
    private static AppTool mAppInfo;
    private static DeviceTool mDevice;
    private static KeyBoardTool mKeyBoard;
    private static RegTool mReg;
    private static TimeTool mTime;
    private static PickerViewTool mPickerView;
    private static CompressHelperTool mCompressHelper;
    private static LuBanCompressTool mLuBanCompress;
    private static AgentwebTooL mAgentweb;
    private static UpdateTool update;
    private static ShowHidePwdTool mShowHidePwd;
    private static ActivityManager mActivityManager;

    public SL() {
        throw new UnsupportedOperationException("not support instantiate Tools");
    }

    public static void init(Application app) {
        if (mApp == null) {
            mApp = app;
        }
    }

    public static Application app() {
        if (mApp == null) {
            throw new RuntimeException("please invoke SL.init(app) on Application#onCreate()"
                    + " and register your Application in manifest.");
        }
        return mApp;
    }

    public static ToastTool toast() {
        if (mToast == null) {
            mToast = ToastTool.getInstance();
        }
        return mToast;
    }

    public static LogTool log() {
        if (mLog == null) {
            mLog = LogTool.getInstance();
        }
        return mLog;
    }

    public static SpTool sp() {
        if (mSp == null) {
            mSp = SpTool.getInstance();
        }
        return mSp;
    }

    public static DensityTool density() {
        if (mDensity == null) {
            mDensity = DensityTool.getInstance();
        }
        return mDensity;
    }


    /**
     * 暂时未封装
     *
     * @return
     */
    public static NetworkTool webview() {
        if (mNetwork == null) {
            mNetwork = NetworkTool.getInstance();
        }
        return mNetwork;
    }

    public static AppTool appInfo() {
        if (mAppInfo == null) {
            mAppInfo = AppTool.getInstance();
        }
        return mAppInfo;
    }

    public static DeviceTool device() {
        if (mDevice == null) {
            mDevice = DeviceTool.getInstance();
        }
        return mDevice;
    }

    /**
     * 键盘打开关闭
     *
     * @return
     */
    public static KeyBoardTool keyBoard() {
        if (mKeyBoard == null) {
            mKeyBoard = KeyBoardTool.getInstance();
        }
        return mKeyBoard;
    }

    /**
     * 正则表达匹配
     *
     * @return
     */
    public static RegTool reg() {
        if (mReg == null) {
            mReg = RegTool.getInstance();
        }
        return mReg;
    }

    public static TimeTool time() {
        if (mTime == null) {
            mTime = TimeTool.getInstance();
        }
        return mTime;
    }

    public static PickerViewTool pickerView() {
        if (mPickerView == null) {
            mPickerView = PickerViewTool.getInstance();
        }
        return mPickerView;
    }

    public static CompressHelperTool compressHelper() {
        if (mCompressHelper == null) {
            mCompressHelper = CompressHelperTool.getInstance();
        }
        return mCompressHelper;
    }

    public static LuBanCompressTool luBanCompress() {
        if (mLuBanCompress == null) {
            mLuBanCompress = LuBanCompressTool.getInstance();
        }
        return mLuBanCompress;
    }

    public static AgentwebTooL agentwebview() {
        if (mAgentweb == null) {
            mAgentweb = AgentwebTooL.getInstance();
        }
        return mAgentweb;
    }

    /**
     * 更新工具
     *
     * @return
     */
    public static UpdateTool update() {
        if (update == null) {
            update = UpdateTool.getInstance();
        }
        return update;
    }

    public static ShowHidePwdTool pwd() {
        if (mShowHidePwd == null) {
            mShowHidePwd = ShowHidePwdTool.getInstance();
        }
        return mShowHidePwd;
    }

    public static ActivityManager activityManager() {
        if (mActivityManager == null) {
            mActivityManager = ActivityManager.getInstance();
        }
        return mActivityManager;
    }
}

package com.sailei.slibrary.utils.density;

import android.util.TypedValue;

import com.sailei.slibrary.SL;

/**
 * @author 韩晓强
 * @date 2018/5/30
 * @describe
 */
public class DensityTool {
    private static volatile DensityTool instance;

    private DensityTool() {
    }

    /**
     * 单例模式之双重检查锁定
     */
    public static DensityTool getInstance() {
        if (instance == null) {
            synchronized (DensityTool.class) {
                if (instance == null) {
                    instance = new DensityTool();
                }
            }
        }
        return instance;
    }

    /**
     * dp转px
     *
     * @return
     */
    public int dp2px(float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, SL.app().getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @return
     */
    public int sp2px(float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, SL.app().getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @param pxVal
     * @return
     */
    public float px2dp(float pxVal) {
        final float scale = SL.app().getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     *
     * @param pxVal
     * @return
     */
    public float px2sp(float pxVal) {
        return (pxVal / SL.app().getResources().getDisplayMetrics().scaledDensity);
    }

}

package com.sailei.slibrary.utils.sp;

import android.content.Context;
import android.content.SharedPreferences;

import com.sailei.slibrary.SL;

/**
 * @author 韩晓强
 * @date 2018/5/29
 * @describe SharedPreferences本地存储工具类
 */
public class SpTool {
    private final static String SP_NAME = "share_data";

    /**
     * 单例模式之静态内部类实现
     */
    private SpTool() {
    }

    private static class LazyHolder {
        private static final SpTool INSTANCE = new SpTool();
    }

    public static final SpTool getInstance() {
        return LazyHolder.INSTANCE;
    }


    /**
     * SP中写入String类型value
     *
     * @param key   键
     * @param value 值
     */
    public void putString(String key, String value) {
        SharedPreferences sp = getSpInstance();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public SharedPreferences getSpInstance() {
        return SL.app().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    /**
     * SP中读取String
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public String getString(String key) {
        SharedPreferences sp = getSpInstance();
        String value;
        value = sp.getString(key, "");
        return value;
    }

    /**
     * SP中写入int类型value
     *
     * @param key   键
     * @param value 值
     */
    public void putInt(String key, int value) {
        SharedPreferences sp = getSpInstance();
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * SP中读取int
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值-1
     */
    public int getInt(String key) {
        SharedPreferences sp = getSpInstance();
        int value;
        value = sp.getInt(key, -1);
        return value;
    }

    /**
     * SP中写入long类型value
     *
     * @param key   键
     * @param value 值
     */
    public void putLong(String key, long value) {
        SharedPreferences sp = getSpInstance();
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * SP中读取long
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值-1
     */
    public long getLong(String key) {
        SharedPreferences sp = getSpInstance();
        long value;
        value = sp.getLong(key, -1L);
        return value;
    }

    /**
     * SP中写入float类型value
     *
     * @param key   键
     * @param value 值
     */
    public void putFloat(String key, float value) {
        SharedPreferences sp = getSpInstance();
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * SP中读取float
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值-1
     */
    public float getFloat(String key) {
        SharedPreferences sp = getSpInstance();
        float value;
        value = sp.getFloat(key, -1F);
        return value;
    }

    /**
     * SP中写入boolean类型value
     *
     * @param key   键
     * @param value 值
     */
    public void putBoolean(String key, boolean value) {
        SharedPreferences sp = getSpInstance();
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * SP中读取boolean
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public boolean getBoolean(String key) {
        SharedPreferences sp = getSpInstance();
        boolean value;
        value = sp.getBoolean(key, false);
        return value;
    }

    /**
     * SP中移除该key
     *
     * @param key 键
     */
    public void remove(String key) {
        SharedPreferences sp = getSpInstance();
        sp.edit().remove(key).apply();
    }


    /**
     * 存放JSON缓存数据
     *
     * @param key     键名
     * @param content 内容
     * @return
     */
    public void putJSONCache(String key, String content) {
        SharedPreferences sp = getSpInstance();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, content);
        editor.apply();

    }

    /**
     * 读取JSON缓存数据
     *
     * @param key 键名
     * @return
     */
    public String readJSONCache(String key) {
        SharedPreferences sp = getSpInstance();
        String jsoncache = sp.getString(key, null);
        return jsoncache;
    }


    /**
     * 清除指定的信息
     *
     * @param name 键名
     * @param key  若为null 则删除name下所有的键值
     */
    public void clearAll(String name, String key) {
        SharedPreferences sharedPreferences = getSpInstance();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (key != null) {
            editor.remove(key);
        } else {
            editor.clear();
        }
        editor.apply();
    }
}

package com.sailei.slibrary.utils.update;

import android.content.Context;

import com.jayfeng.update.AU;
import com.jayfeng.update.AUConfig;
import com.sailei.slibrary.SL;

/**
 * @describe: 更新工具
 * @author: 武梁
 * @date: 2018/6/1 10:22
 * @mailbox: 1034905058@qq.com
 */

public class UpdateTool {
    /**
     * 使用方式: build.gradle(app)添加
     *         defaultConfig {
     *             resValue "string", "au_provider_file_authorities", "com.sailei.sltools.fileprovider"
     *    }
     */
    private static volatile UpdateTool instance;
    private static  AUConfig auConfig;

    public static UpdateTool getInstance() {
        if (instance==null) {
            instance = new UpdateTool();
        }
        return instance;
    }

    /**
     * 初始化
     * @param res
     */
    private   void init(int res) {
        if (auConfig==null) {
            auConfig = new AUConfig();
            // must
            auConfig.setContext(SL.app().getApplicationContext()); // Context
            auConfig.setUpdateIcon(res); // Notification icon
            // optional
            auConfig.setDownloadWhenCacel(true);
            AU.init(auConfig);
        }
    }

    /**
     * 强制更新
     * @param context
     * @param localVersion  比如1
     * @param versionnumber 比如1.0.1
     * @param url  比如www.baidu.com
     * @param message 比如 更新ui,修改bug
     * @param res 通知栏上的图标
     */
    public  void forcedupdating(Context context,int localVersion,String versionnumber,String url,String message,int res){
        init(res);
        AU.show(context,
                localVersion,versionnumber,url, message, true);
    }

    /**
     * 普通更新
     * @param context
     * @param localVersion  比如1
     * @param versionnumber 比如1.0.1
     * @param url  比如www.baidu.com
     * @param message 比如 更新ui,修改bug
     * @param res 通知栏上的图标
     */
    public  void update(Context context,int localVersion,String versionnumber,String url,String message,int res){
        init(res);
        AU.show(context,
                localVersion,versionnumber,url, message, false);
    }
}

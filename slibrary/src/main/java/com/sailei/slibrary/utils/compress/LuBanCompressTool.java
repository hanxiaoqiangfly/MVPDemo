package com.sailei.slibrary.utils.compress;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;

import com.sailei.slibrary.SL;

import java.io.File;

import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * @author 韩晓强
 * @date 2018/5/30
 * @describe 文件压缩2---鲁班压缩    详见  https://github.com/Curzibn/Luban
 */
public class LuBanCompressTool {
    private static volatile LuBanCompressTool instance;

    private LuBanCompressTool() {
    }

    /**
     * 单例模式之双重检查锁定
     */
    public static LuBanCompressTool getInstance() {
        if (instance == null) {
            synchronized (LuBanCompressTool.class) {
                if (instance == null) {
                    instance = new LuBanCompressTool();
                }
            }
        }
        return instance;
    }

    private String getPath() {
        String path = Environment.getExternalStorageDirectory() + "/Luban/image/";
        File file = new File(path);
        if (file.mkdirs()) {
            return path;
        }
        return path;
    }

    public void compressFile(Context context, File file, final OnLuBanCompressListener listener) {
        Luban.with(context)
                .load(file)
                .ignoreBy(100)//100k以下忽略
                .setTargetDir(getPath())
                .filter(new CompressionPredicate() {
                    @Override
                    public boolean apply(String path) {

                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                    }
                })
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(File fileResult) {
                        SL.log().i("onSuccess1" + fileResult.getAbsolutePath());
                        listener.onLuBanCompressSuccess(fileResult);
                    }

                    @Override
                    public void onError(Throwable e) {
                        SL.toast().showShortToast(e.getMessage());
                    }
                }).launch();
    }

    public void compressFile(Context context, String filePath, final OnLuBanCompressListener listener) {
        Luban.with(context)
                .load(filePath)
                .ignoreBy(100)
                .setTargetDir(getPath())
                .filter(new CompressionPredicate() {
                    @Override
                    public boolean apply(String path) {
                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                    }
                })
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSuccess(File file) {
                        listener.onLuBanCompressSuccess(file);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                }).launch();
    }

    public void compressFile(Context context, Uri uri, final OnLuBanCompressListener listener) {
        Luban.with(context)
                .load(uri)
                .ignoreBy(100)
                .setTargetDir(getPath())
                .filter(new CompressionPredicate() {
                    @Override
                    public boolean apply(String path) {
                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                    }
                })
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onSuccess(File file) {
                        listener.onLuBanCompressSuccess(file);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                }).launch();

    }

    public interface OnLuBanCompressListener {
        void onLuBanCompressSuccess(File fileResult);
    }
}

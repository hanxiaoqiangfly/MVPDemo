package com.sailei.slibrary.utils.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

import id.zelory.compressor.Compressor;

/**
 * @author 韩晓强
 * @date 2018/5/30
 * @describe 文件压缩1---CompressHelper  详见 https://github.com/zetbaitsu/Compressor
 */
public class CompressHelperTool {
    private static volatile CompressHelperTool instance;

    private CompressHelperTool() {
    }

    /**
     * 单例模式之双重检查锁定
     */
    public static CompressHelperTool getInstance() {
        if (instance == null) {
            synchronized (CompressHelperTool.class) {
                if (instance == null) {
                    instance = new CompressHelperTool();
                }
            }
        }
        return instance;
    }

    public File compressFile(Context context, File orgFile, int maxWidth, int maxHeight, int quality) {
        try {

            return new Compressor(context)
                    .setMaxWidth(maxWidth)
                    .setMaxHeight(maxHeight)
                    .setQuality(quality)
                    .setCompressFormat(Bitmap.CompressFormat.PNG)
                    .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES).getAbsolutePath())
                    .compressToFile(orgFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bitmap compressFileToBitmap(Context context, File file) {

        try {
            return new Compressor(context).compressToBitmap(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bitmap compressFileToBitmap(Context context, String filePath) {
        return compressFileToBitmap(context, new File(filePath));
    }

    public File compressFile(Context context, File file) {
        try {
            return new Compressor(context).compressToFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

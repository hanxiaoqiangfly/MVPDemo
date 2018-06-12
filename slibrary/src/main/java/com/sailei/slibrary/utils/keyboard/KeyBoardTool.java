package com.sailei.slibrary.utils.keyboard;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * @author 韩晓强
 * @date 2018/5/30
 * @describe  键盘打开关闭
 */
public class KeyBoardTool {
    private static volatile KeyBoardTool instance;

    private KeyBoardTool() {
    }

    /**
     * 单例模式之双重检查锁定
     */
    public static KeyBoardTool getInstance() {
        if (instance == null) {
            synchronized (KeyBoardTool.class) {
                if (instance == null) {
                    instance = new KeyBoardTool();
                }
            }
        }
        return instance;
    }

    /**
     * 打开软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void openKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void closeKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

}

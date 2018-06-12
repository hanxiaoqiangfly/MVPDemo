package com.sailei.slibrary.utils.pwd;

import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

/**
 * @author 韩晓强
 * @date 2018/6/4
 * @describe
 */
public class ShowHidePwdTool {

    private static volatile ShowHidePwdTool instance;

    private ShowHidePwdTool() {
    }

    public static ShowHidePwdTool getInstance() {
        if (instance == null) {
            synchronized (ShowHidePwdTool.class) {
                if (instance == null) {
                    instance = new ShowHidePwdTool();
                }
            }
        }
        return instance;
    }

    public void pwdShowOrHide(EditText editText, boolean isShow) {
        if (isShow) {
            //如果选中，显示密码
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            //否则隐藏密码
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (!TextUtils.isEmpty(editText.getText())) {
            editText.setSelection(editText.getText().length());
        }
    }
}

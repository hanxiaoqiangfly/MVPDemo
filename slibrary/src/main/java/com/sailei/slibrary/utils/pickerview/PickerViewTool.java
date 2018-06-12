package com.sailei.slibrary.utils.pickerview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 韩晓强
 * @date 2018/5/30
 * @describe 选择器（选择性别、job、生日）
 */
public class PickerViewTool {
    private static volatile PickerViewTool instance;

    private PickerViewTool() {
    }

    /**
     * 单例模式之双重检查锁定
     */
    public static PickerViewTool getInstance() {
        if (instance == null) {
            synchronized (PickerViewTool.class) {
                if (instance == null) {
                    instance = new PickerViewTool();
                }
            }
        }
        return instance;
    }

    public void showSexPicker(Context context, final TextView textView) {
        final List<String> sexItem = new ArrayList<>();
        sexItem.clear();
        sexItem.add("男");
        sexItem.add("女");
        OptionsPickerView mPickerSex = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                textView.setText(sexItem.get(options1));
            }
        })
                .isDialog(false)
                .setCancelText("取消")
                .setTitleText("性别")
                .setSubmitText("确定")
                .build();

        mPickerSex.setPicker(sexItem);
        mPickerSex.show();
    }

    public void showJobPicker(Context context, final TextView textView) {
        final List<String> jobItem = new ArrayList<>();
        jobItem.clear();
        jobItem.add("上班族");
        jobItem.add("学生族");
        jobItem.add("自由职业者");
        jobItem.add("其他");
        OptionsPickerView mPickerJob = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                textView.setText(jobItem.get(options1));
            }
        })
                .isDialog(false)
                .setCancelText("取消")
                .setTitleText("职业")
                .setSubmitText("确定")
                .build();

        mPickerJob.setPicker(jobItem);
        mPickerJob.show();
    }

    public void showBirthdayPicker(Context context, final TextView textView) {
        Calendar selectedDate = Calendar.getInstance();
        //时间选择器
        TimePickerView mPickerBirthday = new TimePickerBuilder(context, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                textView.setText(getTime(date, "yyyy-MM-dd"));
            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("", "", "", "", "", "")
                .isCenterLabel(false)
                .setDividerColor(Color.DKGRAY)
                .setContentTextSize(21)
                .setTitleText("出生日期")
                .setDate(selectedDate)
                .setDecorView(null)
                .build();
        mPickerBirthday.show(textView);
    }

    public void showCityView(Context context, final TextView textView, List mProvinceModels, List<List> mCityModels, List<List<List>> mDistrictModels) {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                textView.setText("");
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK)
                .setContentTextSize(20)
                .build();

        pvOptions.setPicker(mProvinceModels, mCityModels, mDistrictModels);
        pvOptions.show();
    }

    private String getTime(Date date, String dateType) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat(dateType);
        return format.format(date);
    }
}

package com.sailei.mvpdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sailei.mvpdemo.bean.MessageCenterBean;
import com.sailei.mvpdemo.view.BaseActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class TestActivity extends BaseActivity {

    @Bind(R.id.tv)
    TextView mTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        present.getData(1, mRetrofitService.getMessageCenter());
    }



    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void bindData(int type, Object data) {
        List<MessageCenterBean> bean = (List<MessageCenterBean>) data;
        Log.i("TAG", type + "setData: " + bean.get(0).getRemarks());
        if (type == 1) {

            mTv.setText(bean.get(0).getTitle());
        } else {
            mTv.setText(bean.get(1).getTitle());
        }
    }


    @OnClick(R.id.tv)
    public void onViewClicked() {
        present.getData(2, mRetrofitService.getMessageCenter());
    }
}

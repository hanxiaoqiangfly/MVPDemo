package com.sailei.mvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.sailei.mvpdemo.bean.MessageCenterBean;
import com.sailei.mvpdemo.view.BaseActivity;
import com.sailei.slibrary.SL;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.tv)
    TextView mTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        present.getData(1, mRetrofitService.getMessageCenter());
        SL.toast().showShortToast("fdfasfdf");
    }


    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void bindData(int type, Object data) {

        if (type == 1) {
            List<MessageCenterBean> bean1 = (List<MessageCenterBean>) data;
            mTv.setText(bean1.get(0).getTitle());
        } else {
            List<MessageCenterBean> bean2 = (List<MessageCenterBean>) data;
            mTv.setText(bean2.get(1).getTitle());

        }
    }


    @OnClick(R.id.tv)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this, TestActivity.class));
    }
}

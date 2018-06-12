package com.sailei.mvpdemo.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sailei.mvpdemo.api.RetrofitFactory;
import com.sailei.mvpdemo.api.RetrofitService;
import com.sailei.mvpdemo.present.Presenter;

import butterknife.ButterKnife;

/**
 * @author 韩晓强
 * @date 2018/6/11
 * @describe
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView{
    protected Presenter present;
    protected Context mContext;
    protected RetrofitService mRetrofitService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        ButterKnife.bind(this);
        mContext = this;
        present = new Presenter(this,this);
        mRetrofitService = RetrofitFactory.getInstance();
    }



    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        if (present != null) {
            present.detach();
            present = null;
        }
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}

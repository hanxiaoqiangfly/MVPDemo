package com.sailei.mvpdemo.present;

import android.content.Context;

import com.sailei.mvpdemo.view.BaseView;
import com.sailei.mvpdemo.mode.ModelImpl;
import com.sailei.mvpdemo.api.BaseResponse;

import io.reactivex.Observable;

/**
 * @author 韩晓强
 * @date 2018/6/11
 * @describe
 */
public class Presenter<T> extends PresenterImpl implements ModelImpl.OnResultListener {

    private ModelImpl<T> mModel;

    public Presenter(BaseView view, Context context) {
        super(view, context);
        mModel = new ModelImpl<>(context);
    }


    public void getData(int type,Observable<BaseResponse<T>> observable) {
        mModel.getData(type,observable, this, this);
    }

    @Override
    public void onSuccess(int type,Object obj) {
        view.bindData(type,obj);
    }
}

package com.sailei.mvpdemo.present;

import android.content.Context;
import android.util.Log;

import com.sailei.mvpdemo.view.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author 韩晓强
 * @date 2018/6/11
 * @describe
 */
public abstract class PresenterImpl<V extends BaseView> implements BasePresenter {
    protected V view;
    Context context;
    public PresenterImpl(V view, Context context) {
        this.view = view;
        this.context = context;
        start();
    }

    @Override
    public void detach() {
        this.view = null;
        this.context = null;
        unDisposable();
    }

    @Override
    public void start() {

    }
    private CompositeDisposable mCompositeDisposable;

    @Override
    public void addDisposable(Disposable subscription) {
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
        Log.i("TAG", "--"+mCompositeDisposable.size());
    }

    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
        Log.i("TAG", "unDisposable--"+mCompositeDisposable.size());
    }
}

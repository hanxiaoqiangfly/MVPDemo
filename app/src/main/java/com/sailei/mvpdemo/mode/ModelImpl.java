package com.sailei.mvpdemo.mode;

import android.content.Context;
import android.util.Log;

import com.sailei.mvpdemo.api.BaseResponse;
import com.sailei.mvpdemo.present.Presenter;
import com.sailei.mvpdemo.widget.LoadingDialog;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 韩晓强
 * @date 2018/6/11
 * @describe
 */
public class ModelImpl<T> {

    LoadingDialog mLoadingDialog;
    Context context;

    public ModelImpl(Context context) {
        this.context = context;
        mLoadingDialog = new LoadingDialog(context);
    }

    public void getData(final int type, Observable<BaseResponse<T>> observable, final Presenter presenter, final OnResultListener listener) {
        observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        presenter.addDisposable(disposable);
                        Log.i("TAG", "accept1: ");
                        showDialog();
                    }
                })
                .flatMap(new Function<BaseResponse<T>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(BaseResponse<T> response) throws Exception {
                        if (response.getStatus() != 0) {
                            return Observable.error(new Throwable());
                        }
                        return Observable.just(response.getData());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        Log.i("TAG", "onNext: ");
                        dismissDialog();
                        if (listener != null) {
                            listener.onSuccess(type, o);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("TAG", "onError: " + e.getMessage());
                        dismissDialog();
                    }

                    @Override
                    public void onComplete() {
                        dismissDialog();
                    }
                });
    }
    private void showDialog() {
        if (mLoadingDialog != null && !mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }
    }

    private void dismissDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    public interface OnResultListener<T> {
        void onSuccess(int type, T result);
    }
}

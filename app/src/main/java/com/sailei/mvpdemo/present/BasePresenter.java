package com.sailei.mvpdemo.present;

import io.reactivex.disposables.Disposable;

/**
 * @author 韩晓强
 * @date 2018/6/11
 * @describe
 */
public interface BasePresenter {
    //默认初始化
    void start();

    //Activity关闭把view对象置为空
    void detach();

    //将网络请求的每一个disposable添加进入CompositeDisposable，再退出时候一并注销
    void addDisposable(Disposable subscription);

    //注销所有请求
    void unDisposable();

}

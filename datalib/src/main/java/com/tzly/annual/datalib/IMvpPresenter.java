package com.tzly.annual.datalib;

/**
 * 控制轴
 */

public interface IMvpPresenter<T> {

    void initMvpView(T view);

    void onSubscribe();

    void unSubscribe();
}

package com.tzly.annual.datalib;

/**
 * View
 */

public interface IMvpView{

    void loadingDialog();

    void dismissDialog();

    void refreshLoading();

    void dismissLoading();

    void initView();

}

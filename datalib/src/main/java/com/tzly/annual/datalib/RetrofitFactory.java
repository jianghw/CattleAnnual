package com.tzly.annual.datalib;

import retrofit2.Retrofit;

/**
 * 构建bases url工厂
 */

public class RetrofitFactory {

    public static RetrofitFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final RetrofitFactory INSTANCE = new RetrofitFactory();
    }

    public Retrofit createRetrofit(int type) {
        return null;
    }

    private String getBaseUrl(int type) {
        switch (type) {
            case 4://后台开发人员本地调试接口
                return "http://192.168.1.127:80/";
            case 5://拍照扫描上传接口
                return "http://liyingtong.com:8080/";
            default:
                return "http://192.168.1.147:80/";
        }
    }
}

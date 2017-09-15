package com.tzly.annual.datalib;

import android.content.Context;

import com.tzly.annual.base.util.ContextHolder;

/**
 * Created by jianghw on 2017/4/26.
 * 依赖注入类
 */

public class Injection {
    /**
     * 初始化数据仓库
     */
    public static RepositoryManager provideRepository() {
        Context applicationContext = ContextHolder.getContext();

        return RepositoryManager.getInstance(
                RemoteData.getInstance(),
                LocalData.getInstance(applicationContext)
        );
    }
}

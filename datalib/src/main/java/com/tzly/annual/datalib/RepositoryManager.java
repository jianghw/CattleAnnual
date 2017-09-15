package com.tzly.annual.datalib;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by jianghw on 2017/4/26.
 * 仓库管理类
 */

public class RepositoryManager {
    @Nullable
    private static RepositoryManager INSTANCE = null;
    @NonNull
    private final RemoteData mRemoteData;
    @NonNull
    private final LocalData mLocalData;

    public static RepositoryManager getInstance(RemoteData remoteData, LocalData localData) {
        if (INSTANCE == null) {
            INSTANCE = new RepositoryManager(remoteData, localData);
        }
        return INSTANCE;
    }

    private RepositoryManager(@NonNull RemoteData remoteData, @NonNull LocalData localData) {
        mRemoteData = remoteData;
        mLocalData = localData;
    }

    /**
     * 获取用户id~
     *
     * @return
     */
    public String getDefaultUserID() {
        return mLocalData.DefaultUserID();
    }

    /**
     * 加密后的userid
     */
    public String getDefaultRASUserID() {
        return mLocalData.getRASUserID();
    }

    /**
     * 这段加密封装
     *
     * @param string
     * @return
     */
    public String getStrByEncryption(String string) {
        return mLocalData.getStrByEncryption(string);
    }

}

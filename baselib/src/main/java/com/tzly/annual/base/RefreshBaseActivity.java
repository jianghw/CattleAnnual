package com.tzly.annual.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by jianghw on 2017/9/12.
 * Description: 基类activity
 * Update by:
 * Update day:
 */

public class RefreshBaseActivity extends JxBaseActivity {

    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int initRootView() {
        return R.layout.base_activity_base_refresh;
    }

    @Override
    protected void bindView(View rootView) {
        mSwipeRefreshLayout = rootView.findViewById(R.id.refresh_layout);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View childView = inflater.inflate(initContentView(), mSwipeRefreshLayout, true);
        bindChildView(childView);
    }

    protected int initContentView() {
        return R.layout.base_custom_base_content;
    }

    protected void bindChildView(View childView) {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

}

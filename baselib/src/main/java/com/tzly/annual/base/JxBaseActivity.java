package com.tzly.annual.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by jianghw on 2017/9/12.
 * Description: 基类activity
 * Update by:
 * Update day:
 */

public abstract class JxBaseActivity extends AppCompatActivity {

    /**
     * 1、当root不为null，attachToRoot为true时，
     * 表示将resource布局添加到root中，resource布局的根节点各个属性都有效,将这个root作为根对象返回
     * <p>
     * 2、如果root不为null，而attachToRoot为false的话，表示不将第一个参数所指定的View添加到root中
     * <p>
     * 3、一个顶级View叫做DecorView，DecorView中包含一个竖直方向的LinearLayout，
     * LinearLayout由两部分组成，第一部分是标题栏，第二部分是内容栏，内容栏是一个FrameLayout
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getRootView());
        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.lay_linear);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Title
        if (!isCustomTitle()) {
            View titleView = inflater.inflate(initTitleView(), null);
            parentLayout.addView(titleView, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            bindTitleView(titleView);
        }

        View contentView = inflater.inflate(initContentView(), null);
        parentLayout.addView(contentView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        bindContentView(contentView);

        showViewByState(initViewState());
    }

    protected int getRootView() {
        return R.layout.base_activity_jx_base;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);

        if (isStatusBar()) initStatusBarColor();
    }

    /**
     * 是否自定义状态栏效果
     */
    protected boolean isStatusBar() {
        return true;
    }

    /**
     * 状态栏颜色
     */
    protected void initStatusBarColor() {
        StatusBarUtils.setColor(this, iniStatusColor(), 38);
    }

    /**
     * 状态栏颜色
     */
    protected int iniStatusColor() {
        return getResources().getColor(R.color.base_colorWhite);
    }

    /**
     * 是否要子布局定义title
     */
    protected boolean isCustomTitle() {
        return false;
    }

    /**
     * Title
     */
    protected int initTitleView() {
        return R.layout.base_custom_base_title;
    }

    protected void bindTitleView(View titleView) {
    }

    /**
     * 显示内容
     */
    protected int initContentView() {
        return R.layout.base_custom_base_content;
    }

    /**
     * 绑定子控件
     */
    protected void bindContentView(View childView) {

    }

    /**
     * @param defaultView 默认布局
     * @param replaceView 替代布局
     */
    protected void transView(final View defaultView, View replaceView) {
        final int index = ((ViewGroup) defaultView.getParent()).indexOfChild(defaultView);
        ViewGroup.LayoutParams params = defaultView.getLayoutParams();
        ViewGroup parent = (ViewGroup) defaultView.getParent();
        parent.removeView(defaultView);
        parent.addView(replaceView, index, params);
    }

    private void errorView(List<View> viewList, View errorView) {
        for (View view : viewList) {
            if (view == null) {
                continue;
            }
            transView(view, errorView);
            break;
        }
    }

    private void succeedView(List<View> viewList, View noNetView) {
        for (View view : viewList) {
            if (view == null) {
                continue;
            }
            transView(noNetView, view);
            break;
        }
    }

    /**
     * 默认为 LOADING 状态
     */
    protected BaseViewState initViewState() {
        return BaseViewState.LOADING;
    }

    protected void showViewByState(BaseViewState currentState) {
        switch (currentState) {
            case LOADING:
                break;
            case SUCCEED:
                break;
            case ERROR:
                break;
            case EMPTY:
                break;
            default:
                break;
        }
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

package com.tzly.annual.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jianghw on 2017/9/12.
 * Description: 基类activity
 * Update by:
 * Update day:
 */

public abstract class JxBaseActivity extends AppCompatActivity {
    private BaseViewState mCurrentState;

    /**
     * 1、当root不为null，attachToRoot为true时，
     * 表示将resource指定的布局添加到root中，添加的过程中resource所指定的的布局的根节点的各个属性都是有效的
     * 2、如果root不为null，而attachToRoot为false的话，表示不将第一个参数所指定的View添加到root中
     * 3、一个顶级View叫做DecorView，DecorView中包含一个竖直方向的LinearLayout，
     * LinearLayout由两部分组成，第一部分是标题栏，第二部分是内容栏，内容栏是一个FrameLayout
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(initRootView(), null);

        ViewGroup parent = (ViewGroup) rootView.getParent();
        //Title
        if (!isCustomTitle()) {
            View titleView = inflater.inflate(initTitleView(), parent, true);
            bindTitleView(titleView);
        }

        setContentView(rootView);

        bindView(rootView);
        View childView = inflater.inflate(initContentView(), parent, true);
        bindChildView(childView);

        showViewByState(initViewState());
    }

    /**
     * 基础布局控件
     */
    protected int initRootView() {
        return R.layout.base_activity_jx_base;
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
     * 绑定控件
     */
    protected abstract void bindView(View rootView);

    /**
     * 显示的内容
     */
    protected int initContentView() {
        return R.layout.base_custom_base_content;
    }

    /**
     * 绑定子控件
     */
    protected void bindChildView(View childView) {

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

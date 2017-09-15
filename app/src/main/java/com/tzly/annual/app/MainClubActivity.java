package com.tzly.annual.app;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tzly.annual.base.RefreshBaseActivity;
import com.tzly.annual.base.custom.ScrollDrawerLayout;
import com.tzly.annual.base.custom.image.CircleImageView;
import com.tzly.annual.base.util.StatusBarUtils;
import com.tzly.annual.datalib.IMainClubContract;

/**
 * 畅通卡车友会
 */
public class MainClubActivity extends RefreshBaseActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        IMainClubContract.IMainClubView {

    private ImageView mImgBack;
    private TextView mTvTitle;
    private ImageView mImgHome;
    private CircleImageView mUserImage;
    private TextView mUserText;

    @Override
    protected void userRefreshData() {

    }

    /**
     * 自定义图标
     */
    protected boolean isCustomTitle() {
        return true;
    }

    @Override
    protected int initChildView() {
        return R.layout.activity_main_club;
    }

    /**
     * 是否自定义状态栏效果
     */

    @Override
    protected void bindChildView(View childView) {
        ScrollDrawerLayout drawer = (ScrollDrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //显示item 图标色
        navigationView.setItemIconTintList(null);
        //获取头布局文件
        View headerView = navigationView.getHeaderView(0);
        mUserImage = (CircleImageView) headerView.findViewById(R.id.img_user);
        mUserText = (TextView) headerView.findViewById(R.id.tv_user);

        initTitle(childView);

        RelativeLayout statusBar = (RelativeLayout) findViewById(R.id.lay_re);
        ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
        layoutParams.height = StatusBarUtils.getStatusBarHeight(getApplicationContext());
        statusBar.setLayoutParams(layoutParams);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Log.e("TAG", "===" + dm.heightPixels);
        Log.e("TAG", "===" + dm.widthPixels);

        StatusBarUtils.setTranslucentForDrawerLayout(this, drawer, 38);
    }

    private void initTitle(View view) {
        mImgBack = (ImageView) view.findViewById(R.id.img_back);
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backClickListener();
            }
        });
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
        mImgHome = (ImageView) view.findViewById(R.id.img_home);
        mImgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClickListener();
            }
        });
    }

    /**
     * 左边图片点击
     */
    protected void backClickListener() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    /**
     * 右边图片点击
     */
    protected void imageClickListener() {
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_club, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        // Handle navigation view item clicks here.
        int id = menuItem.getItemId();

        if (id == R.id.nav_order) {
            // Handle the camera action
        } else if (id == R.id.nav_msg) {

        } else if (id == R.id.nav_questions) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void loadingDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void refreshLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void initView() {

    }
}

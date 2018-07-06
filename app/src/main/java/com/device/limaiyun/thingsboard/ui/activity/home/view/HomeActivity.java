package com.device.limaiyun.thingsboard.ui.activity.home.view;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.device.limaiyun.thingsboard.ui.fragment.home.AppFragment.view.AppFragment;
import com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.view.CmriFragment;
import com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.view.HomeFragment;
import com.device.limaiyun.thingsboard.ui.fragment.home.MyFragment.view.MyFragment;
import com.device.limaiyun.thingsboard.utils.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/12 0012.
 */

public class HomeActivity extends BaseActivity implements HomeView {
    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.rb_home)
    RadioButton rbMsg;
    @BindView(R.id.rb_cmr)
    RadioButton rbCmr;
    @BindView(R.id.rb_app)
    RadioButton rbApp;
    @BindView(R.id.rb_my)
    RadioButton rbMy;
    private Fragment[] mFragments;
    private int mIndex;


    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup contentView = window.getDecorView().findViewById(Window.ID_ANDROID_CONTENT);
            contentView.getChildAt(0).setFitsSystemWindows(false);
        }
    }

    @Override
    public void initFragment() {
        HomeFragment homeFragment = new HomeFragment();
        CmriFragment cmriFragment = new CmriFragment();
        AppFragment appFragment = new AppFragment();
        MyFragment myFragment = new MyFragment();

        mFragments = new Fragment[]{homeFragment,cmriFragment,appFragment,myFragment};
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl_main,homeFragment).commit();
        setIndexSelector(0);
    }

    private void setIndexSelector(int index) {
        if (mIndex == index){
            return;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(mFragments[index]);
        if (!mFragments[index].isAdded()){
            ft.add(R.id.fl_main,mFragments[index]).replace(R.id.fl_main,mFragments[index]).show(mFragments[index]);
        }else {
            ft.add(R.id.fl_main,mFragments[index]).show(mFragments[index]);
        }
        ft.commit();
        mIndex = index;
    }

    @Override
    public void initData() {
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    DecodedJWT jwt = JWT.decode(TokenBean.TOKEN);
//                    Log.e("jwt",jwt.toString());
//                } catch (JWTDecodeException exception){
//                    //Invalid token
//                }
//
//            }
//        }.start();
    }

    @OnClick(R.id.rb_home)
    public void getHomeFragment(){
        setIndexSelector(0);
    }

    @OnClick(R.id.rb_cmr)
    public void getCmrFragment(){
        setIndexSelector(1);
    }

    @OnClick(R.id.rb_app)
    public void getAppFragment(){
        setIndexSelector(2);
    }

    @OnClick(R.id.rb_my)
    public void getMyFragment(){
        setIndexSelector(3);
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hinddenLoading() {

    }


}

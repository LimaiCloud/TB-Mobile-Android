package com.device.limaiyun.thingsboard.ui.activity.home.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.ui.fragment.home.AppFragment.view.AppFragment;
import com.device.limaiyun.thingsboard.ui.fragment.home.CmriFragment.view.CmriFragment;
import com.device.limaiyun.thingsboard.ui.fragment.home.MessageFragment.view.MessageFragment;
import com.device.limaiyun.thingsboard.ui.fragment.home.MyFragment.view.MyFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/12 0012.
 */

public class HomeActivity extends BaseActivity implements HomeView {
    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.rb_msg)
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
    public void initFragment() {
        MessageFragment messageFragment = new MessageFragment();
        CmriFragment cmriFragment = new CmriFragment();
        AppFragment appFragment = new AppFragment();
        MyFragment myFragment = new MyFragment();

        mFragments = new Fragment[]{messageFragment,cmriFragment,appFragment,myFragment};
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl_main,messageFragment).commit();
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

    @OnClick(R.id.rb_msg)
    public void getMsgFragment(){
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
}

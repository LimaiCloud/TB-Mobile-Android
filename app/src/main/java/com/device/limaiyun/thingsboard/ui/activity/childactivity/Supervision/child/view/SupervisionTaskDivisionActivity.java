package com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.view.View;
import android.widget.LinearLayout;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseActivity;
import com.device.limaiyun.thingsboard.bean.WeKanTitleBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.addSupervisionChild.view.AddSupervisionActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.Supervision.child.presenter.SupervisionTaskDivisionPresenter;
import com.device.limaiyun.thingsboard.ui.fragment.supervision.view.SupervisionFragment;
import com.device.limaiyun.thingsboard.utils.ScaleTransitionPagerTitleView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${Winter} on 2018/9/19.
 */
public class SupervisionTaskDivisionActivity extends BaseActivity implements SupervisionTaskDivisionView {

    private static final int REQUESTCODE = 1;
    @BindView(R.id.supervision_magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.ll_back)
    LinearLayout ll_back;
    private SupervisionTaskDivisionPresenter presenter;
    private List<String> mTitleLists;
    private CommonNavigator mCommonNavigator;
    private List<Fragment> mViewLists;
    private SupervisionFragment fragment;
    private String wekan_token;
    private String board_id;
    private String user_id;

    @Override
    protected int getLayout() {
        return R.layout.activity_supervision_task_division;
    }

    @Override
    public void initView() {
        mCommonNavigator = new CommonNavigator(this);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        board_id = intent.getStringExtra("ID");
        wekan_token = intent.getStringExtra("WEKAN_TOKEN");
        user_id = intent.getStringExtra("user_id");
        if (board_id != null){
            presenter = new SupervisionTaskDivisionPresenter(this);
            presenter.getTitle(board_id, wekan_token);
        }
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
    }

    @OnClick(R.id.ll_back)
    public void finishAct(){
        finish();
    }

    @OnClick(R.id.iv_add)
    public void addSupervision(){
        Intent intent = new Intent(this, AddSupervisionActivity.class);
        intent.putExtra("board_id",board_id);
        intent.putExtra("wekan_token",wekan_token);
        intent.putExtra("user_id",user_id);
        startActivityForResult(intent,REQUESTCODE);
    }

    @Override
    public void showPageIndictor(final List<WeKanTitleBean> weKanTitleBeans,String url) {
        mTitleLists = new ArrayList<>();
        mViewLists = new ArrayList<>();
        for (int i = 0; i < weKanTitleBeans.size(); i++) {
            mTitleLists.add(weKanTitleBeans.get(i).getTitle());
        }
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(),weKanTitleBeans,url,wekan_token);
        viewPager.setAdapter(adapter);

        mCommonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleLists == null ? 0 : mTitleLists.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ScaleTransitionPagerTitleView titleView = new ScaleTransitionPagerTitleView(context);
                titleView.setText(mTitleLists.get(index));
                TextPaint paint = titleView.getPaint();
                paint.setFakeBoldText(true);
                titleView.setNormalColor(Color.parseColor("#88888888"));
                titleView.setSelectedColor(Color.parseColor("#3783D2"));
                titleView.setSelected(true);
                titleView.setTextSize(18.0f);

                titleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                    }
                });
                return titleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
//                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
//                indicator.setStartInterpolator(new AccelerateInterpolator());
//                indicator.setEndInterpolator(new DecelerateInterpolator(1.6f));
////                indicator.setYOffset(UIUtil.dip2px(context, 39));
                indicator.setLineHeight(UIUtil.dip2px(context, 2));
//                    indicator.setLineWidth(UIUtil.dip2px(context,15));
                indicator.setColors(Color.parseColor("#3783D2"));
                return indicator;
            }

        });
        magicIndicator.setNavigator(mCommonNavigator);
        //设置viewpage页面发生改变,指示器发生改变
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        private List<WeKanTitleBean> weKanTitleBeans;
        private String url;
        private String token;

        public MyViewPagerAdapter(FragmentManager fm, List<WeKanTitleBean> weKanTitleBeans,String url,String token) {
            super(fm);
            this.weKanTitleBeans = weKanTitleBeans;
            this.url = url;
            this.token = token;
        }

        @Override
        public Fragment getItem(int position) {
            return SupervisionFragment.newInstance(url,weKanTitleBeans.get(position).get_id(),token,weKanTitleBeans);
        }

        @Override
        public int getCount() {
            return mTitleLists.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleLists.get(position);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2){
            if (requestCode == REQUESTCODE){
                presenter.getTitle(board_id, wekan_token);
            }
        }
    }
}

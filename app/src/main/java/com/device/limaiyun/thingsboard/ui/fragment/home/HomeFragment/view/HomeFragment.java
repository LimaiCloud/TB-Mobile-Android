package com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.view;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseFragment;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.alarm.view.AlarmActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.data.view.DataActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.view.EquipmentActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.newmessage.view.NewMessageActivity;
import com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.presenter.HomePresenter;
import com.device.limaiyun.thingsboard.utils.GlideImageLoader;
import com.device.limaiyun.thingsboard.utils.LooperTextView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

public class HomeFragment extends BaseFragment implements HomeView{

    @BindView(R.id.looper_textview)
    LooperTextView looperTextView;
    @BindView(R.id.rl_equipment_msg)
    RelativeLayout equipment_msg;
    @BindView(R.id.rl_data_msg)
    RelativeLayout data_msg;
    @BindView(R.id.home_banner)
    Banner homeBanner;
    @BindView(R.id.rl_message)
    RelativeLayout rl_message;
    @BindView(R.id.rl_alarm)
    RelativeLayout rl_alarm;
    private List<Integer> list_path;
    private List<String> list_title;
    private HomePresenter presenter;

    @Override
    public void setUpData() {
//        presenter.getCustomer();
        list_path = new ArrayList<Integer>();
        list_title = new ArrayList<>();
        list_path.add(R.mipmap.home_banner1);
        list_path.add(R.mipmap.home_banner2);
        list_title.add("标题1");
        list_title.add("标题2");
        homeBanner.setImages(list_path).setImageLoader(new GlideImageLoader()).start();
//        homeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//        homeBanner.setImages(list_path);
//        homeBanner.setImageLoader(new GlideImageLoader());
//        homeBanner.setBannerAnimation(Transformer.DepthPage);
//        homeBanner.setBannerTitles(list_title);
//        homeBanner.isAutoPlay(true);
//        homeBanner.setDelayTime(1500);
//        homeBanner.setIndicatorGravity(BannerConfig.CENTER);
//        homeBanner.start();
        looperTextView.setTipList(generateTips());
    }

    private List<String> generateTips() {
        List<String> tips = new ArrayList<>();
        tips.add("第一条消息......");
        tips.add("第二条消息......");
        tips.add("第三条消息......");
        tips.add("第四条消息......");
        tips.add("第五条消息......");
        tips.add("第六条消息......");
        tips.add("第七条消息......");
        tips.add("第八条消息......");
        tips.add("第九条消息......");
        tips.add("第十条消息......");
        tips.add("第十条消息......");
        return tips;
    }

    @Override
    public void setUpView() {
    }

    @Override
    public void init() {
        presenter = new HomePresenter(this);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_msg;
    }

    @OnClick(R.id.rl_equipment_msg)
    public void showEqipmentMsg(){
        Intent intent = new Intent(getContext(),EquipmentActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_data_msg)
    public void showDataMsg(){
        Intent intent = new Intent(getContext(),DataActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_message)
    public void showMessage(){
        Intent intent = new Intent(getContext(),NewMessageActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_alarm)
    public void showAlarm(){
        Intent intent = new Intent(getContext(), AlarmActivity.class);
        startActivity(intent);
    }


    @Override
    public void initCustomerSuc() {

    }

    @Override
    public void initCustomerFail() {

    }
}

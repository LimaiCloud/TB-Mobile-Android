package com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.view;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.auth0.android.jwt.JWT;
import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseFragment;
import com.device.limaiyun.thingsboard.bean.DecodeTokenBean;
import com.device.limaiyun.thingsboard.bean.TokenBean;
import com.device.limaiyun.thingsboard.bean.WantedBean;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.alarm.view.AlarmActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.data.view.DataActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.equipment.view.EquipmentActivity;
import com.device.limaiyun.thingsboard.ui.activity.childactivity.newmessage.view.NewMessageActivity;
import com.device.limaiyun.thingsboard.ui.activity.wanted.view.WantedWebViewActivity;
import com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.presenter.HomePresenter;
import com.device.limaiyun.thingsboard.utils.GlideImageLoader;
import com.device.limaiyun.thingsboard.utils.LooperTextView;
import com.youth.banner.Banner;

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
    private DecodeTokenBean decodeTokenBean;


    @Override
    public void setUpData() {

//        presenter.getCustomer();
        presenter.getTitle();
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
    }



    @Override
    public void setUpView() {
    }

    @Override
    public void init() {
        presenter = new HomePresenter(this);
        JWT jwt = new JWT(TokenBean.TOKEN);
        decodeTokenBean = new DecodeTokenBean();
        decodeTokenBean.setSub(jwt.getSubject());
//        decodeTokenBean.setUserId(jwt.getClaim("userId").asString());
//        decodeTokenBean.setEnabled(jwt.getClaim("enabled").asBoolean());
//        decodeTokenBean.setIsPublic(jwt.getClaim("isPublic").asBoolean());
//        decodeTokenBean.setTenantId(jwt.getClaim("tenantId").asString());
        decodeTokenBean.setCustomerId(jwt.getClaim("customerId").asString());
//        decodeTokenBean.setIss(jwt.getClaim("iss").asString());
//        decodeTokenBean.setIat(jwt.getClaim("iat").asInt());
        decodeTokenBean.setScopes(jwt.getClaim("scopes").asList(String.class));
//        decodeTokenBean.setExp(jwt.getClaim("exp").asInt());
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
        intent.putExtra("scopes",decodeTokenBean.getScopes().get(0));
        intent.putExtra("customerId",decodeTokenBean.getCustomerId());
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

    @Override
    public void getWantedTitle(List<WantedBean> wantedBean) {
        if (wantedBean != null){
            for (int i = 0; i < wantedBean.size(); i++) {
                looperTextView.setTipList(generateTips(wantedBean.get(0)));
                looperTextView.setOnClickListener(new LooperTextViewListener(wantedBean.get(0)));
            }
        }
    }

    private List<String> generateTips(WantedBean wantedBean) {
        List<String> tips = new ArrayList<>();
        tips.add(wantedBean.getTitle().getRendered());
        return tips;
    }

    private class LooperTextViewListener implements View.OnClickListener {
        private WantedBean bean;
        public LooperTextViewListener(WantedBean wantedBean) {
            bean = wantedBean;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getContext(), WantedWebViewActivity.class);
            intent.putExtra("link",bean.getLink());
            startActivity(intent);
        }
    }
}

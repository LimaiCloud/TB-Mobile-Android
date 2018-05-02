package com.device.limaiyun.thingsboard.ui.fragment.home.HomeFragment.view;

import com.device.limaiyun.thingsboard.R;
import com.device.limaiyun.thingsboard.base.BaseFragment;
import com.device.limaiyun.thingsboard.utils.GlideImageLoader;
import com.device.limaiyun.thingsboard.utils.LooperTextView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

public class HomeFragment extends BaseFragment {

    private List<Integer> list_path;
    private List<String> list_title;
    @BindView(R.id.home_banner)
    Banner homeBanner;
    @BindView(R.id.looper_textview)
    LooperTextView looperTextView;

    @Override
    protected void setUpData() {
        list_path = new ArrayList<Integer>();
        list_title = new ArrayList<>();
        list_path.add(R.mipmap.home_banner1);
        list_path.add(R.mipmap.home_banner1);
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
    protected void setUpView() {
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_msg;
    }


}

package com.device.limaiyun.thingsboard.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/4/16 0016.
 */

public abstract class BaseFragment extends Fragment {

    private View contentView;
    private BaseActivity activity;
    private Unbinder mUnbinder;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(getFragmentLayout(),container,false);
        mUnbinder = ButterKnife.bind(this,contentView);
        activity = (BaseActivity) getContext();
        init();
        setUpView();
        setUpData();
        return contentView;
    }

    protected abstract void setUpData();

    protected abstract void setUpView();

    protected abstract void init();

    protected abstract int getFragmentLayout();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null)mUnbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

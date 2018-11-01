 package com.zhengsr.cuslib.support;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.zhengsr.cuslib.support.callback.IZBackInterface;

/**
 * Created by zhengshaorui
 * Time on 2018/11/1
 */

public class ZBaseSupporFragment extends Fragment {
    private static final String TAG = "ZBaseSupporFragment";
    protected FragmentActivity _mActivity;
    protected SupporFragment mSupporFragment;
    private IZBackInterface mZBackInterface;
    //Fragment的View加载完毕的标记
    private boolean isViewCreated;

    //Fragment对用户可见的标记
    private boolean isUIVisible;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        lazyLoad();
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        _mActivity = (FragmentActivity) context;
        mSupporFragment = SupporFragment.getInstance();
        if (getActivity() instanceof IZBackInterface){
            mZBackInterface = (IZBackInterface) getActivity();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        _mActivity = (FragmentActivity) activity;
        mSupporFragment = SupporFragment.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mZBackInterface != null) {
            mZBackInterface.onBackPress(this);
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }


    private void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            lazyLoadView();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
        }
    }
    public void lazyLoadView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //页面销毁,恢复标记
        isViewCreated = false;
        isUIVisible = false;
    }

    public  boolean onPressBack(){
        return false;
    }
}

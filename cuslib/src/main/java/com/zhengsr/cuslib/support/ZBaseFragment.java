package com.zhengsr.cuslib.support;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by zhengshaorui
 * Time on 2018/10/13
 */

public abstract class ZBaseFragment extends ZSupporFragment {
    protected ViewGroup mView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        mView = (ViewGroup) LayoutInflater.from(getContext()).inflate(getLayoutId(),container,false);

        //防止fragment，show,hide事件穿透问题，这里截取事件的传递
        mView.setClickable(true); //这样设置会让 focus 被父布局截取，遥控会用不了
        //所以这里设置有线让子控件先获取焦点
        mView.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);

        initView(mView);
        return mView;
    }


    public abstract int getLayoutId();
    public abstract void initView(View view);

    public <T extends View> T getViewById(int viewId){
        return (T)mView.findViewById(viewId);
    }



}

package com.ist.commonlib.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.ist.cuslib.support.ZSupporFragment;
import com.ist.cuslib.support.anim.ZsAnimUtils;

/**
 * Created by zhengshaorui
 * Time on 2018/10/31
 */

public class TestFragment extends ZSupporFragment {
    private static final String TAG = "OneFragment";
    private String mMsg;
    public static Fragment newInstance(String title){
        TestFragment fragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TAG,title);
        fragment.setArguments(bundle);
        return fragment;
    } 

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView textView = new TextView(_mActivity);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        if (getArguments() != null){
            mMsg = getArguments().getString(TAG);
            textView.setText(mMsg);
        }
        return textView;
    }

    @Override
    public void lazyLoadView() {
        super.lazyLoadView();
        Log.d(TAG, "zsr --> 我可见了: "+mMsg);
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return ZsAnimUtils.fadeAnim(_mActivity,enter);
    }
}

package com.zhengsr.commonlib.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.zhengsr.commonlib.R;
import com.zhengsr.cuslib.support.ZSupporFragment;
import com.zhengsr.cuslib.support.anim.ZsAnimUtils;

/**
 * Created by zhengshaorui
 * Time on 2018/10/31
 */

public class OneFragment extends ZSupporFragment {
    private static final String TAG = "OneFragment";
    public static Fragment newInstance(){
        OneFragment fragment = new OneFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_test,container,false);
        TextView textView = (TextView) view.findViewById(R.id.test_tv);
        textView.setText("第一个fragment");
        view.findViewById(R.id.test_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // showOrHideFragment(TwoFragment.newInstance(),OneFragment.this);
                replaceFragment(TwoFragment.newInstance());
            }
        });
        return view;

    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return ZsAnimUtils.transLeftAnim(_mActivity,enter);
    }
}

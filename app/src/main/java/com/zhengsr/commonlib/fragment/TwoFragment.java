package com.zhengsr.commonlib.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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

public class TwoFragment extends ZSupporFragment {
    private static final String TAG = "OneFragment";
    public static Fragment newInstance(){
        TwoFragment fragment = new TwoFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Log.d(TAG, "zsr --> onCreateAnimation: "+enter+" "+nextAnim);
        return ZsAnimUtils.transRightAnim(getActivity(),enter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_test,container,false);
        View bgView = view.findViewById(R.id.test_ly);
        bgView.setBackgroundColor(Color.GRAY);
        TextView textView = (TextView) view.findViewById(R.id.test_tv);
        textView.setText("第二个fragment");
        view.findViewById(R.id.test_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showOrHideFragment(OneFragment.newInstance(),TwoFragment.this);
            }
        });
        return view;

    }

    @Override
    public boolean onPressBack() {
        showOrHideFragment(OneFragment.newInstance(),TwoFragment.this);
        return true;
    }
}

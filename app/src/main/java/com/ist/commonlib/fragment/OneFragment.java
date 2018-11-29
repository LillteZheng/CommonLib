package com.ist.commonlib.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ist.commonlib.R;
import com.ist.cuslib.support.ZSupporFragment;

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

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_one,container,false);
        TextView textView = (TextView) view.findViewById(R.id.test_tv);
        textView.setText("第一个fragment");
        Log.d(TAG, "zsr --> fragment one: ");
        view.findViewById(R.id.test_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // replaceFragment(TwoFragment.newInstance(),true, ZsAnimUtils.RIGHT_IN_LEFT_OUT);


               showAndHideFragment(TwoFragment.newInstance(),OneFragment.class);

            }
        });
        return view;

    }


}

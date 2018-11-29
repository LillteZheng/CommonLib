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

public class TwoFragment extends ZSupporFragment {
    private static final String TAG = "OneFragment";
    public static Fragment newInstance(){
        TwoFragment fragment = new TwoFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_test,container,false);
        View bgView = view.findViewById(R.id.test_ly);
        TextView textView = (TextView) view.findViewById(R.id.test_tv);
        textView.setText("第二个fragment");
        Log.d(TAG, "zsr --> fragmen two: ");
        view.findViewById(R.id.test_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //目标明确，我点击就是要跳到第二个fragment
                showAndHideFragment(OneFragment.newInstance(),TwoFragment.class);

            }
        });
        return view;

    }

    @Override
    public boolean onPressBack() {
       // showAndHideFragment(OneFragment.newInstance(),TwoFragment.class);
       // popFragment();
        return false;
    }
}

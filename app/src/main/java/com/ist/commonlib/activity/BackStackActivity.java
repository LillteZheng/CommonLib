package com.ist.commonlib.activity;

import android.os.Bundle;
import android.view.View;

import com.ist.commonlib.R;
import com.ist.commonlib.fragment.OneFragment;
import com.ist.commonlib.fragment.TestFragment;
import com.ist.cuslib.support.base.ZBaseSupporActivity;

public class BackStackActivity extends ZBaseSupporActivity {
    private static final String TAG = "BackStackActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstack);
        if (!findFragment(OneFragment.class)){
            loadRootFragment(R.id.content_id, TestFragment.newInstance("第一个"));
        }

    }


    public void back(View view) {
        popFragment();
    }

    public void privious(View view) {
        showAndHideFragment(OneFragment.newInstance(),
                TestFragment.class,
                true);

    }
}

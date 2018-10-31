package com.zhengsr.commonlib;

import android.os.Bundle;

import com.zhengsr.commonlib.fragment.OneFragment;
import com.zhengsr.cuslib.support.ZSupporActivity;

public class MainActivity extends ZSupporActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!findFragment(OneFragment.class)){
            loadRootFragment(R.id.content_id,OneFragment.newInstance());
        }

    }
}

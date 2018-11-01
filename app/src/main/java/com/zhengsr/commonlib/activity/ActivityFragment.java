package com.zhengsr.commonlib.activity;

import android.os.Bundle;

import com.zhengsr.commonlib.R;
import com.zhengsr.commonlib.fragment.OneFragment;
import com.zhengsr.cuslib.support.ZSupporActivity;

public class ActivityFragment extends ZSupporActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        if (!findFragment(OneFragment.class)){
            loadRootFragment(R.id.content_id,OneFragment.newInstance());
        }

    }
}

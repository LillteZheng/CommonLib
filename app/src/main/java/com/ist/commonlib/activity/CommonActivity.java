package com.ist.commonlib.activity;

import android.os.Bundle;

import com.ist.commonlib.R;
import com.ist.commonlib.fragment.OneFragment;
import com.ist.cuslib.support.base.ZBaseSupporActivity;

public class CommonActivity extends ZBaseSupporActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //处理重启，屏幕翻转，不用担心fragment重叠问题
        if (!findFragment(OneFragment.class)){
            loadRootFragment(R.id.content_id,OneFragment.newInstance());
        }

    }


}

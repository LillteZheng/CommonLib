package com.ist.commonlib.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ist.commonlib.R;
import com.ist.commonlib.fragment.IntentFragment;
import com.ist.commonlib.fragment.TestFragment;
import com.ist.cuslib.support.base.ZBaseSupporActivity;

public class IntentActivity extends ZBaseSupporActivity {
    private static final String TAG = "IntentActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        if (!findFragment(TestFragment.class)){
            loadRootFragment(R.id.content_id, IntentFragment.newInstance());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "zsr -->IntentActivity  onActivityResult: "+requestCode);
    }
}

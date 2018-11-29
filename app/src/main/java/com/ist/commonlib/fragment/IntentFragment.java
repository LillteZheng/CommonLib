package com.ist.commonlib.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ist.commonlib.Constant;
import com.ist.commonlib.R;
import com.ist.commonlib.activity.FragmentTestActivity;
import com.ist.cuslib.support.base.ZBaseFragment;

/**
 * Created by zhengshaorui
 * Time on 2018/11/10
 */

public class IntentFragment extends ZBaseFragment {
    private static final String TAG = "IntentFragment";
    private TextView mTextView;

    public static IntentFragment newInstance() {

        Bundle args = new Bundle();

        IntentFragment fragment = new IntentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_intent;
    }

    @Override
    public void initView(View view) {
        mTextView = getViewById(R.id._fragment_text);
        mTextView.setText("测试fragment之间的数据跳转");
        getViewById(R.id.skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(_mActivity, FragmentTestActivity.class), Constant.CODE_NUM);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Constant.CODE_NUM){
            String msg = data.getStringExtra(Constant.TAG_TEST);
            mTextView.setText(msg);
        }

    }
}

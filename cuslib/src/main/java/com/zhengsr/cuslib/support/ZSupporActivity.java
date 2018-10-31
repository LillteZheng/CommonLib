package com.zhengsr.cuslib.support;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.zhengsr.cuslib.support.callback.ZBackInterface;

/**
 * Created by zhengshaorui
 * Time on 2018/10/13
 */

public class ZSupporActivity extends AppCompatActivity implements ZBackInterface {
    private static final String TAG = "ZSupporActivity";
    private SupporFragment mSupporFragment;
    private ZSupporFragment mZSupporFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSupporFragment = SupporFragment.getInstance()
                .addFragmentManager(getSupportFragmentManager());

    }

    protected boolean findFragment(Class<?> aClass){
        return mSupporFragment.findFragment(aClass);
    }

    protected void loadRootFragment(int contentId,Fragment fragment){
        mSupporFragment.loadRootFragment(contentId,fragment);
    };

    protected void showAndHideOtherFragment(Fragment showfragment){
        mSupporFragment.showAndHideOtherFragment(showfragment,false);
    }


    @Override
    public void onBackPress(ZSupporFragment fragment) {
        mZSupporFragment = fragment;
    }

    @Override
    public void onBackPressed() {
        if (mZSupporFragment != null && mZSupporFragment.onPressBack()){
            return;
        }
        super.onBackPressed();
    }
}

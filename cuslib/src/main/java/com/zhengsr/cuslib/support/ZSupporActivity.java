package com.zhengsr.cuslib.support;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.zhengsr.cuslib.support.callback.IZBackInterface;

/**
 * Created by zhengshaorui
 * Time on 2018/10/13
 */

public class ZSupporActivity extends AppCompatActivity implements IZBackInterface {
    private static final String TAG = "ZSupporActivity";
    private SupporFragment mSupporFragment;
    private ZBaseSupporFragment mZSupporFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSupporFragment = SupporFragment.getInstance()
                .addFragmentManager(getSupportFragmentManager());

    }


    @Override
    public void onBackPress(ZBaseSupporFragment fragment) {
        mZSupporFragment = fragment;
    }

    @Override
    public void onBackPressed() {
        if (mZSupporFragment != null && mZSupporFragment.onPressBack()){
            return;
        }
        super.onBackPressed();
    }


    //***************************************
    // support fragment 的方法
    //***************************************

    /**
     * fragment 是否已经在fragmentmanager中
     * @param aClass
     * @return
     */
    protected boolean findFragment(Class<?> aClass){
        return mSupporFragment.findFragment(aClass);
    }

    /**
     * 加载根fragment
     * @param contentId
     * @param fragment
     */
    protected void loadRootFragment(int contentId,Fragment fragment){
        mSupporFragment.loadRootFragment(contentId,fragment);
    };

    /**
     * 显示当前fragment，隐藏其他fragment，不加回退栈
     * @param showfragment
     */
    protected void showAndHideOtherFragment(Fragment showfragment){
        mSupporFragment.showAndHideOtherFragment(showfragment,false);
    }
    /**
     * 显示当前fragment，隐藏其他fragment
     * @param showfragment
     */
    protected void showAndHideOtherFragment(Fragment showfragment, boolean addBackpop){
        mSupporFragment.showAndHideOtherFragment(showfragment,addBackpop);
    }


    protected void showOrHideFragment(Fragment showFragment, Fragment hideFragment){
        mSupporFragment.showOrHideFragment(showFragment,hideFragment,false);
    }

    protected void showOrHideFragment(Fragment showFragment, Fragment hideFragment, boolean addBackStatck){
        mSupporFragment.showOrHideFragment(showFragment,hideFragment,addBackStatck);
    }

    /**
     * 替换fragment
     * @param fragment
     */
    protected void replaceFragment(Fragment fragment){
        mSupporFragment.replaceFragment(fragment);
    }

}

package com.zhengsr.cuslib.support;

import android.support.v4.app.Fragment;


/**
 * Created by zhengshaorui
 * Time on 2018/10/18
 */

public abstract class ZSupporFragment extends ZBaseSupporFragment {


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

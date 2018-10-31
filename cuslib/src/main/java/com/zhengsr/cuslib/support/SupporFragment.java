package com.zhengsr.cuslib.support;

import android.annotation.SuppressLint;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import java.util.List;

public class SupporFragment {
    private static final String TAG = "SupporFragment";
    private FragmentManager mFragmentManager;
    private int mContentId;
    private TextView mTextView;

    
    private static class Holder {
        static final SupporFragment INSTANCE = new SupporFragment();
    }
    
    public static SupporFragment getInstance() {
        return Holder.INSTANCE;
    }
    
    private SupporFragment() {
    }

    public SupporFragment addFragmentManager(FragmentManager fm){
        mFragmentManager = fm;
        return this;
    }


    public SupporFragment addFragmentManager(TextView textView){
        mTextView = textView;
        return this;
    }

    public SupporFragment setTitle(String msg){
        if (mTextView != null){
            mTextView.setText(msg);
        }
        return this;
    }


    public boolean findFragment(Class<?> aClass){
        return mFragmentManager.findFragmentByTag(aClass.getName())!= null;
    }


    /**
     * 加载第一个fragment
     * @param fragment
     */
    public SupporFragment loadRootFragment(@IdRes int contentId,Fragment fragment){
        mContentId = contentId;
        addOrShowFragment(mFragmentManager,contentId,fragment,fragment.getClass().getName(),false);
        return this;
    }


    public SupporFragment addContentId(int layoutid){
        mContentId = layoutid;
        return this;
    }


    /**
     * 隐藏所有的fragment
     */
    public void hideAllFragment(FragmentManager fragmentManager){
        List<Fragment> fragments = fragmentManager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != null){
                FragmentTransaction ft =  fragmentManager.beginTransaction();
                ft.hide(fragment);
                ft.commit();
            }

        }

    }



    /**
     * 添加或者显示fragment
     * @param fragment
     * @param tag
     */
    private void addOrShowFragment(FragmentManager fm,int contentId,Fragment fragment, String tag, boolean addBackStack){
        if (fragment != null){
            FragmentTransaction ft =  fm.beginTransaction();
            if (!fragment.isAdded()){
                ft.add(contentId,fragment,tag);
            }
            ft.show(fragment);
            if (addBackStack){
                ft.addToBackStack(tag);
            }
            ft.commit();
        }

    }


    /**
     * 隐藏其他 fragment
     * @param showFragment
     * @param addBackstack
     */
    public void showAndHideOtherFragment(Fragment showFragment, boolean addBackstack){

        hideAllFragment(mFragmentManager);
        addOrShowFragment(mFragmentManager,mContentId,showFragment,showFragment.getClass().getName(),addBackstack);

    }

    /**
     * 隐藏其他 fragment
     * @param showFragment
     * @param addBackstack
     */
    public void showAndHideOtherFragment(FragmentManager fm ,int contentId,Fragment showFragment, boolean addBackstack){

        hideAllFragment(fm);
        addOrShowFragment(fm,contentId,showFragment,showFragment.getClass().getName(),addBackstack);

    }


    /**
     * 移除fragment
     * @param fragment
     */
    public void removeFragment(Fragment fragment){
        if (fragment != null) {
            mFragmentManager.beginTransaction().remove(fragment).commit();
        }
    }

    /**
     * 替换fragment
     * @param fragment
     */
    @SuppressLint("ResourceType")
    public void replaceFragment(Fragment fragment){
        if (fragment != null) {
            mFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    //前面两个为进入和退出，后面则为进栈和出栈
                    .replace(mContentId, fragment).commit();
        }
    }

    /**
     * 替换fragment
     * @param fragment
     * @param tag
     */
    @SuppressLint("ResourceType")
    public void replaceFragment(Fragment fragment, String tag){
        if (fragment != null) {
            mFragmentManager.beginTransaction()
                   /* .setCustomAnimations(R.anim.right_in,R.anim.left_out,
                            R.anim.left_in,R.anim.right_out)*/
                    .addToBackStack(null)

                    .replace(mContentId, fragment,tag).commit();
        }
    }

    /**
     * 获取当前fragment
     * @return
     */
    public Fragment getCurrentFragment(){
        List<Fragment> fragments = mFragmentManager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != null && fragment.isVisible()){
                return fragment;
            }
        }
        return null;
    }


    public void ShowOrHideFragment(Fragment showFragment,Fragment hideFragment,boolean addBackStack){

        Fragment hFragment = mFragmentManager.findFragmentByTag(hideFragment.getClass().getName());

        FragmentTransaction ft =  mFragmentManager.beginTransaction();
        if (!showFragment.isAdded()){
            ft.add(mContentId,showFragment,showFragment.getClass().getName());
        }else{
            Fragment sFragment = mFragmentManager.findFragmentByTag(showFragment.getClass().getName());
            ft.show(sFragment);

        }
        if (hFragment != null) {
            ft.hide(hFragment);
        }

        if (addBackStack){
            mFragmentManager.popBackStackImmediate();
            ft.addToBackStack(null);
        }
        ft.commit();
    }
}
package com.zhengsr.cuslib.support;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.zhengsr.cuslib.support.callback.ZBackInterface;


/**
 * Created by zhengshaorui
 * Time on 2018/10/18
 */

public abstract class ZSupporFragment extends Fragment {
    protected FragmentActivity _mActivity;
    private SupporFragment mSupporFragment;
    private ZBackInterface mZBackInterface;

   public  boolean onPressBack(){
       return false;
   }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        _mActivity = (FragmentActivity) context;
        mSupporFragment = SupporFragment.getInstance();
        if (getActivity() instanceof ZBackInterface){
            mZBackInterface = (ZBackInterface) getActivity();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        _mActivity = (FragmentActivity) activity;
        mSupporFragment = SupporFragment.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        mZBackInterface.onBackPress(this);
    }

    //supportfragment

    protected boolean findFragment(Class<?> aClass){
        return mSupporFragment.findFragment(aClass);
    }

    protected void loadRootFragment(int contentId,Fragment fragment){
        mSupporFragment.loadRootFragment(contentId,fragment);
    };

    protected void showAndHideOtherFragment(Fragment showfragment){
        mSupporFragment.showAndHideOtherFragment(showfragment,false);
    }
    protected void showAndHideOtherFragment(Fragment showfragment, boolean addBackpop){
        mSupporFragment.showAndHideOtherFragment(showfragment,addBackpop);
    }
    protected void showAndHideOtherFragment(FragmentManager fragmentManager, int parentContentId, Fragment showfragment){
        mSupporFragment.showAndHideOtherFragment(fragmentManager,parentContentId,showfragment,false);
    }

    protected void ShowOrHideFragment(Fragment showFragment, Fragment hideFragment){
        mSupporFragment.ShowOrHideFragment(showFragment,hideFragment,false);
    }

    protected void ShowOrHideFragment(Fragment showFragment, Fragment hideFragment,boolean addBackStatck){
        mSupporFragment.ShowOrHideFragment(showFragment,hideFragment,addBackStatck);
    }
}

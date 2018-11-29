package com.ist.commonlib.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ist.commonlib.R;
import com.ist.commonlib.fragment.TestFragment;

import java.util.ArrayList;
import java.util.List;

public class LazyActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mFragments.add(TestFragment.newInstance("测试1"));
        mFragments.add(TestFragment.newInstance("测试2"));
        mFragments.add(TestFragment.newInstance("测试3"));
        mFragments.add(TestFragment.newInstance("测试4"));
        mFragments.add(TestFragment.newInstance("测试5"));

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new DemoAdapter(getSupportFragmentManager()));
    }



    class DemoAdapter extends FragmentPagerAdapter{

        public DemoAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}

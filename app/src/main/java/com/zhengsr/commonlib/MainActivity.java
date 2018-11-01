package com.zhengsr.commonlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhengsr.commonlib.activity.ActivityFragment;
import com.zhengsr.commonlib.activity.LazyActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void fragment_hide(View view) {
        startActivity(new Intent(this, ActivityFragment.class));
    }

    public void fragment_lazy(View view) {
        startActivity(new Intent(this, LazyActivity.class));
    }
}

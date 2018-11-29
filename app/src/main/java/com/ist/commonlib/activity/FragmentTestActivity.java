package com.ist.commonlib.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ist.commonlib.Constant;
import com.ist.commonlib.R;

public class FragmentTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
    }

    public void ComonClick(View view) {
        startActivity(new Intent(this,CommonActivity.class));
    }


    public void LazyClick(View view) {
        startActivity(new Intent(this,LazyActivity.class));
    }

    public void BackStackClick(View view) {
        startActivity(new Intent(this,BackStackActivity.class));
    }

    public void IntentClick(View view) {
        startActivity(new Intent(this,IntentActivity.class));
    }

    public void back_intent(View view) {
        Intent intent = new Intent();
        intent.putExtra(Constant.TAG_TEST,"返回数据成功啦");
        setResult(Constant.CODE_NUM,intent);
        finish();
    }
}

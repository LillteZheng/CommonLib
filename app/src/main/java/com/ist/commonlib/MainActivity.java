package com.ist.commonlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ist.commonlib.activity.FragmentTestActivity;
import com.ist.cuslib.utils.RxUtils;
import com.ist.cuslib.view.CusPassEditView;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.just("sss")
                .compose(RxUtils.<String>rxScheduers())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d(TAG, "zsr --> accept: "+s);
                    }
                });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com/")
                //转字符串
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                //.client(getOkhttpClient())
                .build();

        CusPassEditView editView = findViewById(R.id.custom);
      //  editView.setError("getstring");
        editView.setLeftRightIcon(-1,R.mipmap.cuslib_eye_show,R.mipmap.cuslib_eye_close);

    }

    public void FragmentTest(View view) {
        startActivity(new Intent(this, FragmentTestActivity.class));
    }
}

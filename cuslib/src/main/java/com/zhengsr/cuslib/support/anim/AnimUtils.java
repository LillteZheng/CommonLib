package com.zhengsr.cuslib.support.anim;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.zhengsr.cuslib.R;

/**
 * Created by zhengshaorui
 * Time on 2018/10/31
 */

public class AnimUtils {

    public static  Animation fadeAnim(Context context,boolean enter){
        if (enter) {
            return AnimationUtils.loadAnimation(context, R.anim.zs_fade_in);
        } else {
            return AnimationUtils.loadAnimation(context, R.anim.zs_fade_out);
        }
    }

    public static  Animation transAnim(Context context,boolean enter){
        if (enter) {
            return AnimationUtils.loadAnimation(context, R.anim.zs_right_in);
        } else {
            return AnimationUtils.loadAnimation(context, R.anim.zs_right_out);
        }
    }
}

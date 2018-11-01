package com.zhengsr.cuslib.support.anim;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.zhengsr.cuslib.R;

/**
 * Created by zhengshaorui
 * Time on 2018/10/31
 */

public class ZsAnimUtils {

    /**
     * 淡入淡出
     * @param context
     * @param enter
     * @return
     */
    public static  Animation fadeAnim(Context context,boolean enter){
        if (enter) {
            return AnimationUtils.loadAnimation(context, R.anim.zs_fade_in);
        } else {
            return AnimationUtils.loadAnimation(context, R.anim.zs_fade_out);
        }
    }

    /**
     * 右入右出
     * @param context
     * @param enter
     * @return
     */
    public static  Animation transRightAnim(Context context, boolean enter){
        if (enter) {
            return AnimationUtils.loadAnimation(context, R.anim.zs_right_in);
        } else {
            return AnimationUtils.loadAnimation(context, R.anim.zs_right_out);
        }
    }

    /**
     * 右入右出
     * @param context
     * @param enter
     * @return
     */
    public static  Animation transLeftAnim(Context context, boolean enter){
        if (enter) {
            return AnimationUtils.loadAnimation(context, R.anim.zs_left_in);
        } else {
            return AnimationUtils.loadAnimation(context, R.anim.zs_left_out);
        }
    }
}

package com.zhengsr.cuslib.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 * Created by zhengshaorui
 * date on 2018/5/17.
 */

public class PackageUtil {
    private static final String TAG = "PackageUtil";

    /**
     * 通过packagename启动应用
     *
     * @param context
     * @param packagename
     */
    public static boolean startAPPFromPackageName(Context context, String packagename) {
        try {
            Intent intent = isexit(context, packagename);
            if (intent == null) {
                return false;
            }
            Log.i(TAG, "APP is found!");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {

        }
        return  false;
    }

    /**
     * 通过packagename判断应用是否安装
     *
     * @param context
     * @param pk_name
     * @return 跳转的应用主activity Intent
     */

    public static Intent isexit(Context context, String pk_name) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(pk_name);
        return intent;
    }
}

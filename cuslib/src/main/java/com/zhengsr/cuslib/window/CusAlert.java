package com.zhengsr.cuslib.window;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class CusAlert {
    private View mView;
    private Context mContext;
    private AlertDialog mAlertDialog;

    private CusAlert(Builder cus) {
        AlertDialog.Builder builder = new AlertDialog.Builder(cus.context);
       mContext = cus.context;
        if (cus.layoutid != -1){
            mView = LayoutInflater.from(cus.context).inflate(cus.layoutid,null);
        }
        if (cus.view != null){
            mView = cus.view;
        }
        if (mView != null){
            builder.setView(mView);
        }
        if (cus.titleId != -1){
            builder.setTitle(cus.titleId);
        }
        if (cus.title != null){
            builder.setTitle(cus.title);
        }

        if (cus.msgId != -1){
            builder.setMessage(cus.msgId);
        }
        if (cus.msg != null){
            builder.setMessage(cus.msg);
        }
        if (cus.positiveId != -1){
            builder.setPositiveButton(cus.positiveId,cus.positiveListner);
        }
        if (cus.negativeId != -1){
            builder.setNegativeButton(cus.negativeId,cus.negativeListner);
        }
        mAlertDialog = builder.create();
        mAlertDialog.show();

        Window window = mAlertDialog.getWindow();
        mAlertDialog.setCancelable(cus.outSideDimiss);

        if (window != null){
            if (cus.width != -1){
                WindowManager.LayoutParams params = mAlertDialog.getWindow().getAttributes();
                params.width = cus.width;
                mAlertDialog.getWindow().setAttributes(params);
            }
            if (cus.height != -1){
                WindowManager.LayoutParams params = mAlertDialog.getWindow().getAttributes();
                params.height = cus.height;
                mAlertDialog.getWindow().setAttributes(params);
            }

        }


    }


    public <T extends View> T getViewById(int resId){
        return (T) (mView != null ? mView.findViewById(resId):mView);
    }

    public CusAlert setTextView(int viewid,String msg){
        TextView textView = getViewById(viewid);
        if (msg != null) {
            textView.setText(msg);
        }
        return this;
    }

    public CusAlert setTextView(int viewid,int redid){
        TextView textView = getViewById(viewid);
        String msg = mContext.getString(redid);
        textView.setText(msg);
        return this;
    }

    public static class Builder{
        Context context;
        int titleId = -1;
        String title = null;
        int msgId = -1;
        String msg = null;
        int positiveId = -1;
        DialogInterface.OnClickListener positiveListner = null;
        int negativeId = -1;
        DialogInterface.OnClickListener negativeListner = null;
        int height = -1;
        int width = -1;
        int layoutid = -1;
        View view = null;
        boolean outSideDimiss = true;

        public Builder setOutSideDimiss(boolean outSideDimiss) {
            this.outSideDimiss = outSideDimiss;
            return this;
        }

        public int getLayoutid() {
            return layoutid;
        }

        public Builder setLayoutid(int layoutid) {
            this.layoutid = layoutid;
            return this;
        }

        public View getView() {
            return view;
        }

        public Builder setView(View view) {
            this.view = view;
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setTitle(int titleId) {
            this.titleId = titleId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMsg(int msgId) {
            this.msgId = msgId;
            return this;
        }

        public Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder setPositive(int positiveId, DialogInterface.OnClickListener listener) {
            this.positiveId = positiveId;
            this.positiveListner = listener;
            return this;
        }



        public Builder setNegativeId(int negativeId,DialogInterface.OnClickListener listener) {
            this.negativeId = negativeId;
            this.negativeListner = listener;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public CusAlert builder(){
            return new CusAlert(this);
        }

    }
}
package com.zhengsr.cuslib.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class LGAdapter<T> extends BaseAdapter {
    
    protected List<T> mDatas;
    private int mLayoutId;
    public LGAdapter(List<T> datas, int layoutid) {
     
        mDatas = datas;
        mLayoutId = layoutid;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public abstract void convert(LGViewHolder viewHolder,T data);

    /**
     * 这里把布局什么的，都在getview中，设置好，其中viewholder是我们的通用的adapter
     * 然后把需要实现的逻辑用抽象方法公布出去，自己去实现
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LGViewHolder viewHolder = LGViewHolder.getViewHolder(viewGroup.getContext(),view,mLayoutId,viewGroup,i);
        convert(viewHolder,getItem(i));
        return viewHolder.getConverView();
    };
    
}

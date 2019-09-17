package com.cymchad.bottomsheet;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者    cpf
 * 时间    2019/8/29
 * 文件    BottomSheet
 * 描述
 */
public class RecyclerViewAdapter extends BaseQuickAdapter<RecyclerEntity, BaseViewHolder> {

    private int position;

    public RecyclerViewAdapter(@LayoutRes int layoutResId, @Nullable List<RecyclerEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder holder, RecyclerEntity item) {
        holder.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_desc, item.getDesc())
                .addOnClickListener(R.id.tv_title)
                .addOnClickListener(R.id.tv_desc);
        /* 通过Activity传递position参数 做Item背景状态的切换*/
//        holder.setBackgroundColor(R.id.rootview, holder.getLayoutPosition() == position ? Color.parseColor("#ffffff") : Color.parseColor("#363636"));
        holder.setBackgroundRes(R.id.rootview, holder.getLayoutPosition() == position ? R.drawable.onclick_btn_shape : R.drawable.onshow_btn_shape);
        /* adapter内的点击 没有直接的position参数 可做一些跳转操作
        * 但没有必要在adapter中做点击处理，Activity内有完善的处理
        * 在这里写的点击事件会拦截Activity内的，甚至会阻拦position参数传递
        * */
//        holder.getView(R.id.rootview).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: 来自adapter内的点击");
//            }
//        });
    }

    public void setSelection(int pos) {
        this.position = pos;
        notifyDataSetChanged();
    }
}

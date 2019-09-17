package com.cymchad.bottomsheet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

@Route(path = "/main/activity")
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private BottomSheetBehavior behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //这里是bottomSheet 状态的改变
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
            }
        });

        //创建列表布局管理
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(manager);
        //创建适配器
        adapter = new RecyclerViewAdapter(R.layout.item_recyclerview, initData());
        //设置适配器
        recyclerView.setAdapter(adapter);
        //打开默认动画
        adapter.openLoadAnimation();
        initListener(this);
    }

    // 为适配器填充数据
    private ArrayList<RecyclerEntity> initData() {
        ArrayList<RecyclerEntity> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            RecyclerEntity entify = new RecyclerEntity();
            entify.setTitle("测试专用标题" + i);
            entify.setDesc("测试专用描述" + i);
            list.add(entify);
        }
        return list;
    }

    // 初始化列表相关的点击事件
    private void initListener(final Context context) {
        /* 该接口针对整个Item布局 可传递position参数*/
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseAdapter, View view, int position) {
                adapter.setSelection(position);
                Toast.makeText(context, "点击了第" + position + "条", Toast.LENGTH_SHORT).show();
            }
        });
        /* 该接口针对Item内控件 可传递position参数*/
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.tv_title) {
                    Toast.makeText(context, "点击了子布局第" + position + "条title", Toast.LENGTH_SHORT).show();
                } else if (view.getId() == R.id.tv_desc) {
                    Toast.makeText(context, "点击了子布局第" + position + "条desc", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /* 使用BottomSheet*/
    public void onClick(View view) {
        /*
        * STATE_COLLAPSED: 折叠关闭状态 app:behavior_peekHeight - 设置折叠时的高度
        * STATE_EXPANDED: 完全展开的状态
        * 同时设置 —> 如果展开则折叠；如果折叠则展开
        * */
        if(behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    /* 使用BottomSheetDialog*/
    public void onClickDialog(View view) {
        BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);
        View layout = getLayoutInflater().inflate(R.layout.dialog_recyclerview, null);

        RecyclerView recyclerView = layout.findViewById(R.id.dialog_recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.openLoadAnimation();
        initListener(this);

        mBottomSheetDialog.setContentView(layout);
        mBottomSheetDialog.show();
    }

    public void onClickLib1 (View view) {
        // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
        ARouter.getInstance().build("/common_http/activity").navigation();
    }

    public void onClickLib2 (View view) {
        // 2. 跳转并携带参数
        ARouter.getInstance().build("/lib2/activity")
                .withLong("key1", 66666)
                .withString("key3", "88888")
                .navigation();
    }
}

package com.cymchad.common_lib.dragger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * 作者    cpf
 * 时间    2019/9/5
 * 文件    BottomSheet
 * 描述
 */
public class TestDraggerActivity extends AppCompatActivity {

    @Inject
    Paint mPaint;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 先编译一下项目 然后Dagger2会自动生成这个类
        // Build --> Rebuild Project 或者 Build --> make module
        DaggerTestDraggerActivityComponent.create().inject(this);
        Toast.makeText(this, mPaint.drawing(), Toast.LENGTH_SHORT).show();
    }
}

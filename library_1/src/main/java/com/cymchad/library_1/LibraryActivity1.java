package com.cymchad.library_1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 作者    cpf
 * 时间    2019/9/2
 * 文件    BottomSheet
 * 描述
 */
@Route(path = "/lib1/activity")
public class LibraryActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib1);
    }

    public void onClickLib1 (View view) {
        ARouter.getInstance().build("/main/activity").navigation();
        finish();
    }

    public void onClickLib (View view) {
        ARouter.getInstance().build("/lib2/activity").navigation();
        finish();
    }
}

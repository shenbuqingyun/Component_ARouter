package com.cymchad.library_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cymchad.lib2.bottomsheet.R;

/**
 * 作者    cpf
 * 时间    2019/9/2
 * 文件    BottomSheet
 * 描述
 */
@Route(path = "/lib2/activity")
public class LibraryActivity2 extends AppCompatActivity {

    private Long longIntent;
    private String stringIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib2);
        longIntent = getIntent().getLongExtra("key1", 0);
        stringIntent = getIntent().getStringExtra("key3");
        Toast.makeText(this, longIntent + " + " + stringIntent, Toast.LENGTH_SHORT).show();
    }

    public void onClickLib2 (View view) {
        ARouter.getInstance().build("/main/activity").navigation();
        finish();
    }

    public void onClickLib (View view) {
        ARouter.getInstance().build("/lib1/activity").navigation();
        finish();
    }
}

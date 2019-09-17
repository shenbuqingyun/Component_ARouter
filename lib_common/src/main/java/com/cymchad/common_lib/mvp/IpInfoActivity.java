package com.cymchad.common_lib.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cymchad.common_lib.R;
import com.cymchad.common_lib.mvp.presenter.IpInfoPresenter;
import com.cymchad.common_lib.util.ActivityUtils;

/**
 * 作者    cpf
 * 时间    2019/9/9
 * 文件    BottomSheet
 * 描述
 */
public class IpInfoActivity extends AppCompatActivity {
    private IpInfoPresenter ipInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipinfo);
        IpInfoFragment ipInfoFragment = (IpInfoFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (ipInfoFragment == null) {
            ipInfoFragment = IpInfoFragment.newInstance(); // 1
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    ipInfoFragment, R.id.contentFrame); // 2
        }
        IpInfoTask ipInfoTask = IpInfoTask.getInstance();
        ipInfoPresenter = new IpInfoPresenter(ipInfoFragment, ipInfoTask);
        ipInfoFragment.setPresenter(ipInfoPresenter); // 3
    }
}


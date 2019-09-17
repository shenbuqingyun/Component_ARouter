package com.cymchad.common_lib.dragger2;


/**
 * 作者    cpf
 * 时间    2019/9/5
 * 文件    BottomSheet
 * 描述
 */
public class RetrofitManager {
    private OkHttpClient mClient;

    public RetrofitManager(OkHttpClient client) {
        mClient = client;
    }

    public OkHttpClient getmClient(){
        return this.mClient;
    }
}

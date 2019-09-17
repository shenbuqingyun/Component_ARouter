package com.cymchad.common_lib.dragger2;

/**
 * 作者    cpf
 * 时间    2019/9/5
 * 文件    BottomSheet
 * 描述
 */
public class OkHttpClient {
    private int cacheSize;

    public OkHttpClient() {

    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public int getCacheSize() {
        return this.cacheSize;
    }
}

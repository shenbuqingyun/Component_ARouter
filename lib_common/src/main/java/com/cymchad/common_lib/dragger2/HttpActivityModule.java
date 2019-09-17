package com.cymchad.common_lib.dragger2;

import dagger.Module;
import dagger.Provides;

/**
 * 作者    cpf
 * 时间    2019/9/5
 * 文件    BottomSheet
 * 描述
 */
@Module
public class HttpActivityModule {
    private int cacheSize;
    public HttpActivityModule(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    @Provides
    OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        client.setCacheSize(this.cacheSize);
        return client;
    }

    @Provides
    RetrofitManager provideRetrofitManager(OkHttpClient client) {
        return new RetrofitManager(client);
    }
}

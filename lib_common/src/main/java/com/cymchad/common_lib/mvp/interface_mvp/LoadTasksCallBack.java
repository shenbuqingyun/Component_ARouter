package com.cymchad.common_lib.mvp.interface_mvp;

/**
 * 作者    cpf
 * 时间    2019/9/9
 * 文件    BottomSheet
 * 描述
 */
public interface LoadTasksCallBack<T> {
    void onSuccess(T t);
    void onStart();
    void onFailed();
    void onFinish();
}


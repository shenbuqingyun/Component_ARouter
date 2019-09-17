package com.cymchad.common_lib.mvp.interface_mvp;

import com.cymchad.common_lib.mvp.interface_mvp.LoadTasksCallBack;

/**
 * 作者    cpf
 * 时间    2019/9/9
 * 文件    BottomSheet
 * 描述
 */
public interface NetTask<T> {
    void execute(T data , LoadTasksCallBack callBack);
}


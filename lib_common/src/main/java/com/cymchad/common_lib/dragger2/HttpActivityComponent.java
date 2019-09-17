package com.cymchad.common_lib.dragger2;

import dagger.Component;

/**
 * 作者    cpf
 * 时间    2019/9/5
 * 文件    BottomSheet
 * 描述
 */
@Component(modules = HttpActivityModule.class)
public interface HttpActivityComponent {
    void inject(HttpActivity activity);
}

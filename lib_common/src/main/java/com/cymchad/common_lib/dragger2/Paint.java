package com.cymchad.common_lib.dragger2;

import javax.inject.Inject;

/**
 * 作者    cpf
 * 时间    2019/9/5
 * 文件    BottomSheet
 * 描述
 */
public class Paint {

    private Paper mPaper;
    @Inject
    public Paint(Paper paper){
        mPaper = paper;
    }

    public String drawing() {
        return mPaper.draw();
    }
}

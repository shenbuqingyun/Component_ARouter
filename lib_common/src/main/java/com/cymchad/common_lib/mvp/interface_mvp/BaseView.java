package com.cymchad.common_lib.mvp.interface_mvp;

/**
 * BaseView中有一个setPresenter()方法，通过该方法，在P的构造函数中将V关联起来。
 */
public interface BaseView<T> {
    void setPresenter(T presenter);
}


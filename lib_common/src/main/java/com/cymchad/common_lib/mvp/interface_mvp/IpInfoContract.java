package com.cymchad.common_lib.mvp.interface_mvp;

import com.cymchad.common_lib.mvp.bean.IpInfo;

/**
 * 作者    cpf
 * 时间    2019/9/9
 * 文件    BottomSheet
 * 描述
 */
public interface IpInfoContract {
    /**
     * Presenter 控制View的行为，同时调度业务逻辑层的行为
     *
     * 以下接口方法：
     * 实现：在IpInfoPresenter中；
     * 调用：在Activity/Fragement中；
     */
    interface Presenter {
        void getIpInfo(String ip);
    }

    /**
     * View接口
     * 只负责显示视图，我们不希望Activity和model有直接的联系，我们可以定义一个View接口，
     * 在这个View接口中定义视图行为的抽象，让具体的Activity来实现。
     * 然后Presenter持有这个View的引用从而能调用View的行为。
     *
     * 以下接口方法：
     * 实现：在Activity/Fragement中；
     * 调用：在IpInfoPresenter中；
     */
    interface View extends BaseView<Presenter> {
        void setIpInfo(IpInfo ipInfo);
        void showLoading();
        void hideLoading();
        void showError();
        boolean isActive();
    }
}


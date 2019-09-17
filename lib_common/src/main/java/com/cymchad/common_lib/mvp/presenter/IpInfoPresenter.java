package com.cymchad.common_lib.mvp.presenter;

import com.cymchad.common_lib.mvp.bean.IpInfo;
import com.cymchad.common_lib.mvp.interface_mvp.IpInfoContract;
import com.cymchad.common_lib.mvp.interface_mvp.LoadTasksCallBack;
import com.cymchad.common_lib.mvp.interface_mvp.NetTask;

/**
 * 作者    cpf
 * 时间    2019/9/9
 * 文件    BottomSheet
 * 描述
 */
public class IpInfoPresenter implements IpInfoContract.Presenter, LoadTasksCallBack<IpInfo> {
    private NetTask netTask;
    private IpInfoContract.View addTaskView;

    public IpInfoPresenter(IpInfoContract.View addTaskView, NetTask netTask) {
        this.netTask = netTask;
        this.addTaskView=addTaskView;
    }

    //请求网络的execute方法 在Presenter的接口方法中进行回调 — 业务层面的逻辑
    @Override
    public void getIpInfo(String ip) {
        netTask.execute(ip,this);
    }

    //View接口方法的调用 在网络请求回调的CallBack方法中 — 视图层面的逻辑
    @Override
    public void onSuccess(IpInfo ipInfo) {
        if(addTaskView.isActive()){
            addTaskView.setIpInfo(ipInfo);
        }
    }

    @Override
    public void onStart() {
        if(addTaskView.isActive()){
            addTaskView.showLoading();
        }
    }

    @Override
    public void onFailed() {
        if(addTaskView.isActive()){
            addTaskView.showError();
            addTaskView.hideLoading();
        }
    }

    @Override
    public void onFinish() {
        if(addTaskView.isActive()){
            addTaskView.hideLoading();
        }
    }
}


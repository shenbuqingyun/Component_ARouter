package com.cymchad.common_lib.dragger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cymchad.common_lib.R;
import com.cymchad.common_lib.rxjava_retrofit.RxWeatherService;
import com.cymchad.common_lib.rxjava_retrofit.WeatherEntity;
import com.cymchad.common_lib.rxjava_retrofit.WeatherService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者    cpf
 * 时间    2019/9/5
 * 文件    BottomSheet
 * 描述
 */
@Route(path = "/common_http/activity")
public class HttpActivity extends AppCompatActivity {
    private static final String TAG = "HttpActivity";
    private static final String BASE_URL = "http://wthrcdn.etouch.cn"; // 如果这里不以/结尾 那接口value里就必须有
    private static final String BASE_URL_1 = "http://wthrcdn.etouch.cn/weather_mini/"; // Wrong
    private static final String BASE_URL_2 = "http://wthrcdn.etouch.cn/weather_mini?city=北京/"; // Wrong
    private TextView mTextView, mTextView2;
    @Inject
    RetrofitManager retrofitManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        DaggerHttpActivityComponent.builder()
                .httpActivityModule(new HttpActivityModule(100))
                .build().inject(this);
        mTextView = findViewById(R.id.retrofitText);
        mTextView2 = findViewById(R.id.rxjavaRetrofitText);
    }

    /**
     * 单纯使用Retrofit的联网请求
     */
    private void doRequestByRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .build();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<WeatherEntity> call = weatherService.getMessage("北京");
        // 异步执行网络请求
        call.enqueue(new Callback<WeatherEntity>() {
            @Override
            public void onResponse(Call<WeatherEntity> call, Response<WeatherEntity> response) {
                //测试数据返回
                WeatherEntity weatherEntity = response.body();
                mTextView.setText(weatherEntity.getData().getGanmao());
                Log.d(TAG, "onResponse: " + weatherEntity.getData().getGanmao());
            }

            @Override
            public void onFailure(Call<WeatherEntity> call, Throwable t) {
                mTextView.setText("Throwable : " + t);
                Log.d(TAG, "onFailure: " + "Throwable : " + t);
            }
        });
    }

    private void doRequestByRxRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
                .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//RxJava 适配器
                .build();
        RxWeatherService rxjavaService = retrofit.create(RxWeatherService.class);
        rxjavaService.getMessage("广州")
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Subscriber<WeatherEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(WeatherEntity weatherEntity) {
                        mTextView2.setText(weatherEntity.getData().getWendu());
                        Log.e("TAG", "response == " + weatherEntity.getData().getWendu());
                    }
                });
    }

    public void onRetrofitClick(View view) {
        doRequestByRetrofit();
    }

    public void onRxJavaRetrofitClick(View view) {
        doRequestByRxRetrofit();
    }
}

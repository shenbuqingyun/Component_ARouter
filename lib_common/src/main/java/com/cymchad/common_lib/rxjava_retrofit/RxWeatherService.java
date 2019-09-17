package com.cymchad.common_lib.rxjava_retrofit;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者    cpf
 * 时间    2019/9/5
 * 文件    BottomSheet
 * 描述
 */
public interface RxWeatherService {
    @GET("/weather_mini")
    Observable<WeatherEntity> getMessage(@Query("city") String city);
}

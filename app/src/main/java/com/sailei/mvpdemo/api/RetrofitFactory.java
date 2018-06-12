package com.sailei.mvpdemo.api;

import android.util.Log;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author 韩晓强
 * @date 2018/6/11
 * @describe
 */
public class RetrofitFactory {
    //访问超时
    private static final long TIMEOUT = 30;
    private static OkHttpClient sHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.e("TAG", "log: " + message);
                }
            }).setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build();
    private static RetrofitService sRetrofitService = new Retrofit.Builder()
            .baseUrl(RetrofitService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(sHttpClient)
            .build()
            .create(RetrofitService.class);

    public static RetrofitService getInstance() {
        return sRetrofitService;
    }
}

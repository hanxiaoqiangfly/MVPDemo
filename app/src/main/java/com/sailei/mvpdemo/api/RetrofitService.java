package com.sailei.mvpdemo.api;

import com.sailei.mvpdemo.bean.MessageCenterBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author 韩晓强
 * @date 2018/6/11
 * @describe
 */
public interface RetrofitService {
    String BASE_URL = "http://dev.saileikeji.com:10030/ebr/";

    @GET("getMessageCenter")
    Observable<BaseResponse<List<MessageCenterBean>>> getMessageCenter();
}

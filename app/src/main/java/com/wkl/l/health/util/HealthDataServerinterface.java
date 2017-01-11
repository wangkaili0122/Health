package com.wkl.l.health.util;




import com.wkl.l.health.bean.BinglisData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by steven on 16/3/29.
 */
public interface HealthDataServerinterface {
   // public static final
    ///////////////////////////////////////////////////////////////////////////
    // GET网络请求方式
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 作用：GET请求最简单的写法,无Path参数和Query参数
     */
    @GET("BingliServlet")
    Call<BinglisData> getInfoList();
}

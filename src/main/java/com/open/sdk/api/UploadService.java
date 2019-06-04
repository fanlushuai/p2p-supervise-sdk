package com.open.sdk.api;

import com.open.sdk.bean.common.Rsp;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 注意：CNCRTEnvConfig是环境变量占位符。会在拦截器里面处理
 * 之所以使用占位符，防止该api不经过拦截器处理。导致误访问线上环境
 */
public interface UploadService {

    @FormUrlEncoded
    @POST("/p2p/userInfo/CNCRTEnvConfig")
    Call<Rsp> user(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/scatterInvest/CNCRTEnvConfig")
    Call<Rsp> borrow(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/status/CNCRTEnvConfig")
    Call<Rsp> borrowStatus(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/repayPlan/CNCRTEnvConfig")
    Call<Rsp> repayment(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/creditor/CNCRTEnvConfig")
    Call<Rsp> credit(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/transferProject/CNCRTEnvConfig")
    Call<Rsp> transfer(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/transferStatus/CNCRTEnvConfig")
    Call<Rsp> transferStatus(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/underTake/CNCRTEnvConfig")
    Call<Rsp> underTake(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/transact/CNCRTEnvConfig")
    Call<Rsp> transaction(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/lendProduct/CNCRTEnvConfig")
    Call<Rsp> product(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/lendProductConfig/CNCRTEnvConfig")
    Call<Rsp> productConfig(@Field("msg") String msg);

    @FormUrlEncoded
    @POST("/p2p/lendParticulars/CNCRTEnvConfig")
    Call<Rsp> lendParticulars(@Field("msg") String msg);

}

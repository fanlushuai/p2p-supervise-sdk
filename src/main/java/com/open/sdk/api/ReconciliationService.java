package com.open.sdk.api;

import com.open.sdk.bean.common.RspBatch;
import com.open.sdk.bean.common.RspResultBatchMessage;
import com.open.sdk.bean.common.RspResultBatchNum;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

public interface ReconciliationService {

    @GET("/balanceService/v15/batchMessage")
    Call<RspBatch<List<RspResultBatchMessage>>> batchMessage(@QueryMap Map<String, String> reqMsg);

    @GET("/balanceService/v15/batchNum")
    Call<RspBatch<RspResultBatchNum>> batchNum(@QueryMap Map<String, String> reqMsg);

    @GET("/balanceService/v15/batchList")
    Call<RspBatch<List<String>>> batchList(@QueryMap Map<String, String> reqMsg);

}

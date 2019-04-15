package com.open.sdk.bean.product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("sourceFinancingCode")
    @Expose
    public String sourceFinancingCode;

    @SerializedName("financingStartTime")
    @Expose
    public String financingStartTime;

    @SerializedName("productName")
    @Expose
    public String productName;

    @SerializedName("rate")
    @Expose
    public String rate;

    @SerializedName("minRate")
    @Expose
    public String minRate;

    @SerializedName("maxRate")
    @Expose
    public String maxRate;

    @SerializedName("term")
    @Expose
    public String term;
}

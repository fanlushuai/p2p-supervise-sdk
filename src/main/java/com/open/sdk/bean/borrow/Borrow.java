package com.open.sdk.bean.borrow;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Borrow {

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("productStartTime")
    @Expose
    public String productStartTime;

    @SerializedName("sourceProductCode")
    @Expose
    public String sourceProductCode;

    @SerializedName("productName")
    @Expose
    public String productName;

    @SerializedName("userIdcardHash")
    @Expose
    public String userIdcardHash;

    @SerializedName("loanUse")
    @Expose
    public String loanUse;

    @SerializedName("loanDescribe")
    @Expose
    public String loanDescribe;

    @SerializedName("loanRate")
    @Expose
    public String loanRate;

    @SerializedName("amount")
    @Expose
    public String amount;

    @SerializedName("surplusAmount")
    @Expose
    public String surplusAmount;

    @SerializedName("term")
    @Expose
    public String term;

    @SerializedName("payType")
    @Expose
    public String payType;

    @SerializedName("serviceCost")
    @Expose
    public String serviceCost;

    @SerializedName("loanType")
    @Expose
    public String loanType;

    @SerializedName("securityType")
    @Expose
    public String securityType;

    @SerializedName("securityCompanyAmount")
    @Expose
    public String securityCompanyAmount;

    @SerializedName("securityCompanyName")
    @Expose
    public String securityCompanyName;

    @SerializedName("securityCompanyIdcard")
    @Expose
    public String securityCompanyIdcard;

    @SerializedName("isFinancingAssure")
    @Expose
    public String isFinancingAssure;

    @SerializedName("securityAmount")
    @Expose
    public String securityAmount;

    @SerializedName("projectSource")
    @Expose
    public String projectSource;
}

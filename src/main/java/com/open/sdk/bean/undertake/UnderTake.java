package com.open.sdk.bean.undertake;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UnderTake {

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("unFinClaimId")
    @Expose
    public String unFinClaimId;

    @SerializedName("transferId")
    @Expose
    public String transferId;

    @SerializedName("finClaimId")
    @Expose
    public String finClaimId;

    @SerializedName("userIdcardHash")
    @Expose
    public String userIdcardHash;

    @SerializedName("takeAmount")
    @Expose
    public String takeAmount;

    @SerializedName("takeInterest")
    @Expose
    public String takeInterest;

    @SerializedName("floatMoney")
    @Expose
    public String floatMoney;

    @SerializedName("takeRate")
    @Expose
    public String takeRate;

    @SerializedName("takeTime")
    @Expose
    public String takeTime;

    @SerializedName("redpackage")
    @Expose
    public String redpackage;

    @SerializedName("lockTime")
    @Expose
    public String lockTime;
}

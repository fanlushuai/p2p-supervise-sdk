package com.open.sdk.bean.invest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Invest {

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("transId")
    @Expose
    public String transId;

    @SerializedName("sourceFinancingCode")
    @Expose
    public String sourceFinancingCode;

    @SerializedName("transType")
    @Expose
    public String transType;

    @SerializedName("transMoney")
    @Expose
    public String transMoney;

    @SerializedName("userIdcardHash")
    @Expose
    public String userIdcardHash;

    @SerializedName("transTime")
    @Expose
    public String transTime;
}

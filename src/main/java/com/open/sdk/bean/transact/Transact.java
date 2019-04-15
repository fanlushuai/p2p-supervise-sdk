package com.open.sdk.bean.transact;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Transact {

    @SerializedName("transTime")
    @Expose
    public String transTime;

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("transId")
    @Expose
    public String transId;

    @SerializedName("sourceProductCode")
    @Expose
    public String sourceProductCode;

    @SerializedName("sourceProductName")
    @Expose
    public String sourceProductName;

    @SerializedName("finClaimId")
    @Expose
    public String finClaimId;

    @SerializedName("transferId")
    @Expose
    public String transferId;

    @SerializedName("replanId")
    @Expose
    public String replanId;

    @SerializedName("transType")
    @Expose
    public String transType;

    @SerializedName("transMoney")
    @Expose
    public String transMoney;

    @SerializedName("userIdcardHash")
    @Expose
    public String userIdcardHash;
}

package com.open.sdk.bean.transfer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Transfer {

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("transferId")
    @Expose
    public String transferId;

    @SerializedName("fromType")
    @Expose
    public String fromType;

    @SerializedName("finClaimId")
    @Expose
    public String finClaimId;

    @SerializedName("userIdcardHash")
    @Expose
    public String userIdcardHash;

    @SerializedName("sourceProductCode")
    @Expose
    public String sourceProductCode;

    @SerializedName("transferAmount")
    @Expose
    public String transferAmount;

    @SerializedName("transferInterest")
    @Expose
    public String transferInterest;

    @SerializedName("floatMoney")
    @Expose
    public String floatMoney;

    @SerializedName("transferDate")
    @Expose
    public String transferDate;
}

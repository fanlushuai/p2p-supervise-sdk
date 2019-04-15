package com.open.sdk.bean.credit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Credit {

    @SerializedName("finClaimId")
    @Expose
    public String finClaimId;

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("sourceProductCode")
    @Expose
    public String sourceProductCode;

    @SerializedName("userIdcardHash")
    @Expose
    public String userIdcardHash;

    @SerializedName("invAmount")
    @Expose
    public String invAmount;

    @SerializedName("invRate")
    @Expose
    public String invRate;

    @SerializedName("invTime")
    @Expose
    public String invTime;

    @SerializedName("redpackage")
    @Expose
    public String redpackage;

    @SerializedName("lockTime")
    @Expose
    public String lockTime;
}

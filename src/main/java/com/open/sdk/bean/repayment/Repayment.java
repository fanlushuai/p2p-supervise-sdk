package com.open.sdk.bean.repayment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Repayment {

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("sourceProductCode")
    @Expose
    public String sourceProductCode;

    @SerializedName("userIdcardHash")
    @Expose
    public String userIdcardHash;

    @SerializedName("totalIssue")
    @Expose
    public String totalIssue;

    @SerializedName("issue")
    @Expose
    public String issue;

    @SerializedName("replanId")
    @Expose
    public String replanId;

    @SerializedName("curFund")
    @Expose
    public String curFund;

    @SerializedName("curInterest")
    @Expose
    public String curInterest;

    @SerializedName("curServiceCharge")
    @Expose
    public String curServiceCharge;

    @SerializedName("repayTime")
    @Expose
    public String repayTime;

}

package com.open.sdk.bean.lendparticulars;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LendParticulars {

    @SerializedName("version")
    @Expose
    public String version;

    @SerializedName("sourceFinancingCode")
    @Expose
    public String sourceFinancingCode;

    @SerializedName("transType")
    @Expose
    public String transType;

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("transId")
    @Expose
    public String transId;

    @SerializedName("transTime")
    @Expose
    public String transTime;

    @SerializedName("transMoney")
    @Expose
    public String transMoney;

    @SerializedName("userIdcardHash")
    @Expose
    public String userIdcardHash;


}

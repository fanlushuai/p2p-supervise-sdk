package com.open.sdk.bean.productconfig;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductConfig {

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("configId")
    @Expose
    public String configId;

    @SerializedName("finClaimId")
    @Expose
    public String finClaimId;

    @SerializedName("sourceFinancingCode")
    @Expose
    public String sourceFinancingCode;

    @SerializedName("userIdcardHash")
    @Expose
    public String userIdcardHash;
}

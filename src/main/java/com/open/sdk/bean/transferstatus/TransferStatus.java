package com.open.sdk.bean.transferstatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransferStatus {

    @SerializedName("version")
    @Expose
    public String version;

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("transferId")
    @Expose
    public String transferId;

    @SerializedName("transferStatus")
    @Expose
    public String transferStatus;

    @SerializedName("amount")
    @Expose
    public String amount;

    @SerializedName("interest")
    @Expose
    public String interest;

    @SerializedName("floatMoney")
    @Expose
    public String floatMoney;

    @SerializedName("productDate")
    @Expose
    public String productDate;
}

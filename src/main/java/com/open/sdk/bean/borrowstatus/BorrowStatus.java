package com.open.sdk.bean.borrowstatus;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BorrowStatus {

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("sourceProductCode")
    @Expose
    public String sourceProductCode;

    @SerializedName("productStatus")
    @Expose
    public String productStatus;

    @SerializedName("productDate")
    @Expose
    public String productDate;
}

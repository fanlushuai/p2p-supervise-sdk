package com.open.sdk.bean.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.open.sdk.bean.user.DataTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class ReqMsgBatch extends ReqMsg {

    /**
     * 只在对账接口中使用
     */
    public void setDataTypeIfBatch(DataTypeEnum dataType) {
        super.dataType = dataType;
    }

    /**
     * 此参数只在对账接口中使用
     */
    @SerializedName("sentDate")
    @Expose
    public String sentDate;

    /**
     * 此参数只在对账接口中使用
     */
    @SerializedName("pageNum")
    @Expose
    public String pageNum;

    /**
     * 此参数在post接口中不用设置，会自动设置。在对账接口中手动设置
     */
    @SerializedName("apiKey")
    @Expose
    public String apiKey;

    /**
     * 此参数只在对账接口中使用
     */
    @SerializedName("putType")
    @Expose
    public String putType;

}

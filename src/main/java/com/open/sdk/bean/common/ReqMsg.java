package com.open.sdk.bean.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.open.sdk.bean.user.DataTypeEnum;
import com.open.sdk.config.ApiKeyGenerateInterceptor;
import com.open.sdk.config.ConfigStorage;
import com.open.sdk.util.Util;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
public class ReqMsg<T> {

    public String toJson() {
        return Util.toJson(this);
    }

    public void setParam(ConfigStorage configStorage, InfTypeEnum infTypeEnum, String batchNum, String checkCode, List dataList) {
        setVersion(configStorage.getVersion());
        setSourceCode(configStorage.getSourceCode());
        setSentTime(Util.getDateTimeStr());
        setTimestamp(System.currentTimeMillis());
        setNonce(Util.genNonce());
        //
        setInfTypeEnum(infTypeEnum);
        setBatchNum(batchNum);
        setCheckCode(checkCode);
        setDataList(dataList);
        setTotalNum(dataList.size() + "");
    }

    @SerializedName("version")
    @Expose
    public String version;

    @SerializedName("batchNum")
    @Expose
    public String batchNum;

    @SerializedName("checkCode")
    @Expose
    public String checkCode;

    /**
     * 本批次发送的总数据条数，一个批次最多传 3000 条数据
     */
    @SerializedName("totalNum")
    @Expose
    public String totalNum;

    @SerializedName("sentTime")
    @Expose
    public String sentTime;

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;

    @SerializedName("infType")
    @Expose
    public InfTypeEnum infTypeEnum;

    /**
     * FBI警告：
     * 通常一定不要自己设置！！！安全隐患，直接给你禁止set
     * retrofit配置情况下，如果设置此值就会采用这个，否则将采用整体配置的,参见{@link ApiKeyGenerateInterceptor}
     * 特殊情况需求，自己设置此值。
     */
    @Setter(AccessLevel.NONE)
    @SerializedName("dataType")
    @Expose
    public DataTypeEnum dataType;

    @SerializedName("timestamp")
    @Expose
    public long timestamp;

    @SerializedName("nonce")
    @Expose
    public String nonce;

    @SerializedName("dataList")
    @Expose
    public List<T> dataList;

}

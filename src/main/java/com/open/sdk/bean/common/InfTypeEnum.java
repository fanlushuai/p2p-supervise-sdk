package com.open.sdk.bean.common;

import com.google.gson.annotations.SerializedName;

import java.util.Optional;

public enum InfTypeEnum {

    @SerializedName("1")
    USER("1", "用户信息接口"),

    @SerializedName("2")
    BORROW("2", "散标信息接口"),

    @SerializedName("4")
    TRANSACTION("4", "交易流水接口"),

    @SerializedName("6")
    BORROW_STATUS("6", "散标状态接口"),

    @SerializedName("81")
    REPAYMENT("81", "还款计划接口"),

    @SerializedName("82")
    CREDIT("82", "初始债券接口"),

    @SerializedName("83")
    TRANSFER("83", "转让信息接口"),

    @SerializedName("84")
    TRANSFER_STATUS("84", "转让状态接口"),

    @SerializedName("85")
    UNDER_TAKE("85", "承接转让接口"),

    @SerializedName("86")
    PRODUCT("86", "产品信息接口"),

    @SerializedName("87")
    PRODUCT_CONFIG("87", "产品配置接口"),

    @SerializedName("88")
    PARTICULARS("88", "投资明细接口");

    private String value;

    private String remark;

    InfTypeEnum(String value, String remark) {
        this.value = value;
        this.remark = remark;
    }

    public static Optional<InfTypeEnum> cover(String value) {
        for (InfTypeEnum infTypeEnum : InfTypeEnum.values()) {
            if (infTypeEnum.getValue().equals(value)) {
                return Optional.of(infTypeEnum);
            }
        }
        return Optional.empty();
    }

    public String getValue() {
        return value;
    }
}

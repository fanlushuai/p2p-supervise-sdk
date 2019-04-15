package com.open.sdk.bean.user;

import com.google.gson.annotations.SerializedName;

/**
 * 接口数据类型；0：调试数据；1 正式数据（接口联调阶段传 0，正式推数据阶段传 1
 */
public enum DataTypeEnum {

    @SerializedName("0")
    TEST("0"),

    @SerializedName("1")
    PRODUCT("1"),
    ;

    String value;

    DataTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

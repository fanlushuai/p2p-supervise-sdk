package com.open.sdk.bean.user;

import com.google.gson.annotations.SerializedName;

public enum UserTyepEnum {

    /**
     * 自然人
     */
    @SerializedName("1")
    PEOPLE,

    /**
     * 企业人
     */
    @SerializedName("2")
    ENTERPRISE
}

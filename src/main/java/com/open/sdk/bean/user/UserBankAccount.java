package com.open.sdk.bean.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UserBankAccount {

    @SerializedName("userBankAccount")
    @Expose
    public String userBankAccount;

}

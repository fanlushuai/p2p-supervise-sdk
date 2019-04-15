package com.open.sdk.bean.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class User {

    @SerializedName("version")
    @Expose
    public String version;

    @SerializedName("userCreateTime")
    @Expose
    public String userCreateTime;

    @SerializedName("sourceCode")
    @Expose
    public String sourceCode;
//
//    @SerializedName("userStatus")
//    @Expose
//    public String userStatus;

    @SerializedName("userType")
    @Expose
    public String userType;

    @SerializedName("userAttr")
    @Expose
    public String userAttr;

    @SerializedName("userName")
    @Expose
    public String userName;

    @SerializedName("countries")
    @Expose
    public String countries;

    @SerializedName("cardType")
    @Expose
    public String cardType;

    @SerializedName("userIdcard")
    @Expose
    public String userIdcard;

    @SerializedName("userIdcardHash")
    @Expose
    public String userIdcardHash;

    @SerializedName("userPhone")
    @Expose
    public String userPhone;

    @SerializedName("userPhoneHash")
    @Expose
    public String userPhoneHash;

    @SerializedName("userUuid")
    @Expose
    public String userUuid;

    @SerializedName("userLawperson")
    @Expose
    public String userLawperson;

    @SerializedName("userFund")
    @Expose
    public String userFund;

    @SerializedName("userProvince")
    @Expose
    public String userProvince;

    @SerializedName("userAddress")
    @Expose
    public String userAddress;

    @SerializedName("registerDate")
    @Expose
    public String registerDate;

    @SerializedName("userMail")
    @Expose
    public String userMail;

    @SerializedName("userSex")
    @Expose
    public String userSex;

    @SerializedName("userList")
    @Expose
    public List<UserBankAccount> bankAccounts;

}

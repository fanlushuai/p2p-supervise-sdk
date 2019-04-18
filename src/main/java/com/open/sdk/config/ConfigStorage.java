package com.open.sdk.config;

import com.open.sdk.bean.user.DataTypeEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ConfigStorage {

    public final String host;

    public final String version;

    public final String sourceCode;

    public final String apiKey;

    public final CNCRTEnv cncrtEnv;

    public final DataTypeEnum dataType;

    @Builder
    public ConfigStorage(String host, String version, String sourceCode, String apiKey, CNCRTEnv cncrtEnv) {
        this.host = host;
        this.version = version;
        this.sourceCode = sourceCode;
        this.apiKey = apiKey;
        this.cncrtEnv = cncrtEnv;
        //根据cncrtEnv自动设置dataType
        if (CNCRTEnv.ONLINE_PRODUCT.equals(cncrtEnv)) {
            this.dataType = DataTypeEnum.PRODUCT;
        } else {
            this.dataType = DataTypeEnum.TEST;
        }
    }

}

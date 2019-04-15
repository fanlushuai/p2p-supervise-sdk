package com.open.sdk.config;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ConfigStorage {

    public final String host;

    public final String version;

    public final String sourceCode;

    public final String apiKey;

    public final CNCRTEnv cncrtEnv;

}

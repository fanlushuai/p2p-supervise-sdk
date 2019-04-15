package com.open.sdk.config;

/**
 * 环境的地址区分：线上环境，分生产和测试，url不带test后缀。测试环境，带test后缀
 * 环境的报文区分：报文中，datatype 1代表生产，1代表调试。
 */
public enum CNCRTEnv {

    /**
     * 测试环境
     */
    TEST,
    /**
     * 线上测试环境
     */
    ONLINE_TEST,
    /**
     * 线上正式环境
     */
    ONLINE_PRODUCT;

}

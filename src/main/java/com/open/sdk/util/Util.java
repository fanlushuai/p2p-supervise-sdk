package com.open.sdk.util;

import com.google.gson.Gson;
import org.cert.open.CertToolV1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Util {

    public final static CertToolV1 certToolV1 = new CertToolV1();

    public final static Gson gson = new Gson();

    private final static DateTimeFormatter dateTimeStrFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final static DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String genNonce() {
        return Integer.toHexString(new Random().nextInt());
    }

    public static String getDateTimeStr() {
        return dateTimeStrFormat.format(LocalDateTime.now());
    }

    public static String getDateStr() {
        return yyyyMMdd.format(LocalDateTime.now());
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }


}

package com.ruoyi.common.utils;

public class GlobalInfo {

    public static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public static String get() {
        return stringThreadLocal.get();
    }

    public static void set(String s) {
        stringThreadLocal.set(s);
    }

}

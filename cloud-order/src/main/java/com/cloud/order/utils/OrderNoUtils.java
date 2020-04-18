package com.cloud.order.utils;

import java.util.UUID;

public class OrderNoUtils {

    public static String genOrderNo() {
        String temp = UUID.randomUUID().toString().replace("-", "");
        temp = temp.substring(temp.length() / 2);
        return temp;
    }
}

package com.renhaixyz.common.xmlbean;

/**
 * renjihai 2015年3月5日
 */
public class TextUtils {
    public static boolean isEmpty(String text) {
        if (text == null || "".equals(text)) {
            return true;
        } else {
            return false;
        }
    }
}

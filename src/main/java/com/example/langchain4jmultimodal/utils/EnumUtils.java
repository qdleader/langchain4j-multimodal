package com.example.langchain4jmultimodal.utils;
import com.example.langchain4jmultimodal.service.BaseEnum;

public class EnumUtils {
    public static <T extends Enum<T> & BaseEnum> T getValueOf(Class<T> enumClass, String code) {
        for (T t : enumClass.getEnumConstants()) {
            if (t.getCode().equals(code)) {
                return t;
            }
        }
        return null;
    }
}

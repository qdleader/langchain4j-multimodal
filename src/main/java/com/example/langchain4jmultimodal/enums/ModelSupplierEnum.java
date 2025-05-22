package com.example.langchain4jmultimodal.enums;

import com.example.langchain4jmultimodal.service.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

//模型厂商枚举
@Getter
@AllArgsConstructor
public enum ModelSupplierEnum implements BaseEnum {
    DASHSCOPE("DASHSCOPE","百炼"),
    KIMI("KIMI","Kimi");

    private String code;
    private String name;
}

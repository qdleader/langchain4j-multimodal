package com.example.langchain4jmultimodal.factory;

import com.example.langchain4jmultimodal.enums.ModelSupplierEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class ModelFactory {
    private static final Map<ModelSupplierEnum, ModelServer> modelServerMap = new HashMap<>();

    static {
        ServiceLoader.load(ModelServer.class).forEach(modelServer -> modelServerMap.put(modelServer.getModelSupplierEnum(), modelServer));
    }

    // 根据厂商获取模型服务
    public static ModelServer getModelServerBysupplier(ModelSupplierEnum modelSupplierEnum) {
        return modelServerMap.get(modelSupplierEnum);
    }
}

package com.example.langchain4jmultimodal.factory;

import ai.djl.Model;
import com.example.langchain4jmultimodal.enums.ModelSupplierEnum;
import com.example.langchain4jmultimodal.request.BaseModelRequestVO;

public interface ModelServer {

    ModelSupplierEnum getModelSupplierEnum();

    Object process(BaseModelRequestVO req);
}

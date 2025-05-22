package com.example.langchain4jmultimodal.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class BaseModelRequestVO {
    private String apiKey;

    private String modelName;

    private String baseUrl;

    private String msg;

    private Long userId;
}

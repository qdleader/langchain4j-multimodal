package com.example.langchain4jmultimodal.service;

import com.example.langchain4jmultimodal.request.BaseModelRequestVO;
import reactor.core.publisher.Flux;

public interface ChatService {
    Flux<String> chat(BaseModelRequestVO req);
}

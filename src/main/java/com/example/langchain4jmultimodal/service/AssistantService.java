package com.example.langchain4jmultimodal.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import reactor.core.publisher.Flux;

public interface AssistantService {
    Flux<String> chat(@MemoryId Long userId, @UserMessage String msg);
}

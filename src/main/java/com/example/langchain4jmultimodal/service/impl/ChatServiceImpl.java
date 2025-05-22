package com.example.langchain4jmultimodal.service.impl;

import com.example.langchain4jmultimodal.request.BaseModelRequestVO;
import com.example.langchain4jmultimodal.service.AssistantService;
import com.example.langchain4jmultimodal.service.ChatService;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.AiServices;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatServiceImpl implements ChatService {

    @Override
    public Flux<String> chat(BaseModelRequestVO req) {
        System.out.println("req = " + req);
        OpenAiStreamingChatModel streamingChatModel = OpenAiStreamingChatModel.builder()
                .apiKey(req.getApiKey())
                .modelName(req.getModelName())
                .baseUrl(req.getBaseUrl())
                .build();

        AssistantService assistantService = AiServices.builder(AssistantService.class)
                .streamingChatLanguageModel(streamingChatModel)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .build();
        return assistantService.chat(req.getUserId(),req.getMsg());
    }
}

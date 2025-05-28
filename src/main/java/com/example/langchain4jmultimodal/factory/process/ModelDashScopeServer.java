package com.example.langchain4jmultimodal.factory.process;

import com.example.langchain4jmultimodal.enums.ModelSupplierEnum;
import com.example.langchain4jmultimodal.factory.ModelServer;
import com.example.langchain4jmultimodal.request.BaseModelRequestVO;
import com.example.langchain4jmultimodal.service.AssistantService;
import com.google.auto.service.AutoService;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.AiServices;


@AutoService(ModelServer.class)
public class ModelDashScopeServer implements ModelServer {

    @Override
    public ModelSupplierEnum getModelSupplierEnum() {
        return ModelSupplierEnum.DASHSCOPE;
    }

    @Override
    public Object process(BaseModelRequestVO req) {

        OpenAiStreamingChatModel streamingChatModel = OpenAiStreamingChatModel.builder()
                .apiKey(req.getApiKey())
                .modelName(req.getModelName())
                .baseUrl(req.getBaseUrl())
                .build();

        AssistantService assistantService = AiServices.builder(AssistantService.class)
                .streamingChatLanguageModel(streamingChatModel)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .build();

                return assistantService.chat(req.getUserId(), req.getMsg());


    }
}

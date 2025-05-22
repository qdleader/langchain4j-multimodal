package com.example.langchain4jmultimodal.controller;


import com.example.langchain4jmultimodal.request.BaseModelRequestVO;
import com.example.langchain4jmultimodal.service.ChatService;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Resource
    private ChatService chatService;

    @PostMapping(value = "/stream",  produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> chat1(@RequestBody BaseModelRequestVO req) {
        System.out.println("111" + req);
        return chatService.chat(req);
    }
}

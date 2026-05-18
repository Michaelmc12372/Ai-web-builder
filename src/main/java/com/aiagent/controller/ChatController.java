package com.aiagent.controller;

import com.aiagent.core.AIAgent;
import com.aiagent.dto.ChatRequest;
import com.aiagent.dto.ChatResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final AIAgent aiAgent;

    public ChatController() {
        this.aiAgent = new AIAgent();
    }

    @PostMapping("/message")
    public ChatResponse sendMessage(@RequestBody ChatRequest request) {
        logger.info("Received message: {}", request.getMessage());
        
        try {
            String response = aiAgent.process(request.getMessage());
            return new ChatResponse(response, true, null);
        } catch (Exception e) {
            logger.error("Error processing message", e);
            return new ChatResponse(null, false, "Error: " + e.getMessage());
        }
    }

    @GetMapping("/health")
    public ChatResponse health() {
        return new ChatResponse("AI Agent is running!", true, null);
    }
}
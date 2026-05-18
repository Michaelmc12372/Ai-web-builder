package com.aiagent.reasoning;

import com.aiagent.memory.ConversationMemory;
import java.util.*;

public class ReasoningEngine {
    private Map<String, String> responseTemplates;

    public ReasoningEngine() {
        initializeTemplates();
    }

    private void initializeTemplates() {
        responseTemplates = new HashMap<>();
        
        responseTemplates.put("CODE_GENERATION", 
            "I'll help you generate code. Based on your request for %s, here's a solution:\n" +
            "```\npublic class Example {\n" +
            "    public static void main(String[] args) {\n" +
            "        // Your implementation here\n" +
            "    }\n" +
            "}\n```");
        
        responseTemplates.put("EXPLANATION",
            "Great question! %s\n" +
            "Here's a brief explanation: %s\n" +
            "Key points:\n" +
            "1. It's a fundamental concept in programming\n" +
            "2. It has practical applications in real-world scenarios\n" +
            "3. Understanding this helps with better code design");
        
        responseTemplates.put("DEBUGGING",
            "I can help you debug this! Here are some steps:\n" +
            "1. Check for null pointer exceptions\n" +
            "2. Review your logic flow\n" +
            "3. Add logging statements\n" +
            "4. Use a debugger to step through the code\n" +
            "5. Check your input validation");
        
        responseTemplates.put("OPTIMIZATION",
            "Here are optimization suggestions:\n" +
            "1. Use more efficient algorithms\n" +
            "2. Cache frequently used data\n" +
            "3. Reduce memory allocations\n" +
            "4. Profile your code to find bottlenecks\n" +
            "5. Use appropriate data structures");
        
        responseTemplates.put("GENERAL_QUERY",
            "I understand your question. Let me help you with that.\n" +
            "Context from our conversation shows: %s\n" +
            "Here's my response: %s");
    }

    public String generateResponse(String intent, List<String> entities, String context, List<ConversationMemory.MemoryEntry> history) {
        String template = responseTemplates.getOrDefault(intent, "I'm here to help! Could you provide more details?");
        
        String entityString = String.join(", ", entities);
        
        // Smart context building
        String response = String.format(template, entityString, context);
        
        // Add personality
        if (intent.equals("CODE_GENERATION")) {
            response += "\n\nWould you like me to explain any part of this code or generate a more specific version?"
        }
        
        return response;
    }
}
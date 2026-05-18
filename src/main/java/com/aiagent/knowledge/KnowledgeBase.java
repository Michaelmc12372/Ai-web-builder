package com.aiagent.knowledge;

import java.util.*;

public class KnowledgeBase {
    private Map<String, String> knowledge;

    public KnowledgeBase() {
        initializeKnowledge();
    }

    private void initializeKnowledge() {
        knowledge = new HashMap<>();
        
        // Programming concepts
        knowledge.put("ALGORITHM", "An algorithm is a step-by-step procedure for solving a problem or accomplishing a task.");
        knowledge.put("DATA_STRUCTURE", "A data structure is a specialized format for organizing and storing data efficiently.");
        knowledge.put("OOP", "Object-Oriented Programming is a programming paradigm based on objects and classes.");
        knowledge.put("DESIGN_PATTERN", "A design pattern is a reusable solution to a common programming problem.");
        
        // Languages
        knowledge.put("JAVA", "Java is a statically-typed, compiled language known for its 'write once, run anywhere' capability.");
        knowledge.put("PYTHON", "Python is a dynamically-typed, interpreted language known for readability and simplicity.");
        knowledge.put("JAVASCRIPT", "JavaScript is a dynamic language primarily used for web development.");
        
        // Best practices
        knowledge.put("PERFORMANCE", "Optimize by using appropriate data structures, algorithms, caching, and profiling.");
        knowledge.put("SECURITY", "Security best practices include input validation, encryption, and principle of least privilege.");
        knowledge.put("DEBUGGING", "Debug by using breakpoints, logging, unit tests, and systematic problem isolation.");
    }

    public String getRelevantKnowledge(String intent, List<String> entities) {
        StringBuilder context = new StringBuilder();
        
        // Add knowledge based on intent
        for (String entity : entities) {
            String key = entity.split(":")[1].toUpperCase();
            if (knowledge.containsKey(key)) {
                context.append(knowledge.get(key)).append(" ");
            }
        }
        
        return context.toString();
    }
}
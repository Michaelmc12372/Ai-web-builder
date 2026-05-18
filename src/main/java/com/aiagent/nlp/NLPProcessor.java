package com.aiagent.nlp;

import java.util.*;

public class NLPProcessor {
    private Map<String, List<String>> intentPatterns;
    private Map<String, List<String>> entityPatterns;

    public NLPProcessor() {
        initializePatterns();
    }

    private void initializePatterns() {
        intentPatterns = new HashMap<>();
        entityPatterns = new HashMap<>();
        
        // Code generation intents
        intentPatterns.put("CODE_GENERATION", Arrays.asList(
            "generate", "create", "write", "build", "make"
        ));
        
        // Explanation intents
        intentPatterns.put("EXPLANATION", Arrays.asList(
            "explain", "what is", "tell me", "describe", "how does"
        ));
        
        // Debugging intents
        intentPatterns.put("DEBUGGING", Arrays.asList(
            "fix", "debug", "error", "bug", "help", "problem"
        ));
        
        // Optimization intents
        intentPatterns.put("OPTIMIZATION", Arrays.asList(
            "optimize", "improve", "performance", "faster", "efficient"
        ));
        
        // Language patterns
        entityPatterns.put("LANGUAGE", Arrays.asList(
            "java", "python", "javascript", "cpp", "csharp", "go", "rust"
        ));
        
        // Framework patterns
        entityPatterns.put("FRAMEWORK", Arrays.asList(
            "spring", "react", "angular", "vue", "django", "flask"
        ));
    }

    public String extractIntent(String input) {
        String lowerInput = input.toLowerCase();
        
        for (Map.Entry<String, List<String>> entry : intentPatterns.entrySet()) {
            for (String pattern : entry.getValue()) {
                if (lowerInput.contains(pattern)) {
                    return entry.getKey();
                }
            }
        }
        
        return "GENERAL_QUERY";
    }

    public List<String> extractEntities(String input) {
        List<String> entities = new ArrayList<>();
        String lowerInput = input.toLowerCase();
        
        for (Map.Entry<String, List<String>> entry : entityPatterns.entrySet()) {
            for (String pattern : entry.getValue()) {
                if (lowerInput.contains(pattern)) {
                    entities.add(entry.getKey() + ":" + pattern);
                }
            }
        }
        
        return entities;
    }
}
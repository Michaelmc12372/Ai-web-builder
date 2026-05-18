package com.aiagent.core;

import com.aiagent.nlp.NLPProcessor;
import com.aiagent.memory.ConversationMemory;
import com.aiagent.knowledge.KnowledgeBase;
import com.aiagent.reasoning.ReasoningEngine;
import java.util.List;

public class AIAgent {
    private NLPProcessor nlpProcessor;
    private ConversationMemory memory;
    private KnowledgeBase knowledgeBase;
    private ReasoningEngine reasoningEngine;

    public AIAgent() {
        this.nlpProcessor = new NLPProcessor();
        this.memory = new ConversationMemory();
        this.knowledgeBase = new KnowledgeBase();
        this.reasoningEngine = new ReasoningEngine();
    }

    public String process(String userInput) {
        // Parse user intent
        String intent = nlpProcessor.extractIntent(userInput);
        List<String> entities = nlpProcessor.extractEntities(userInput);
        
        // Store in memory
        memory.addInteraction(userInput, intent);
        
        // Get relevant knowledge
        String context = knowledgeBase.getRelevantKnowledge(intent, entities);
        
        // Reason and generate response
        String response = reasoningEngine.generateResponse(intent, entities, context, memory.getHistory());
        
        // Store response in memory
        memory.addResponse(response);
        
        return response;
    }
}
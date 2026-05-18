package com.aiagent.memory;

import java.util.*;

public class ConversationMemory {
    private List<MemoryEntry> history;
    private static final int MAX_HISTORY = 100;

    public ConversationMemory() {
        this.history = new ArrayList<>();
    }

    public void addInteraction(String userInput, String intent) {
        MemoryEntry entry = new MemoryEntry(userInput, intent, "user");
        history.add(entry);
        
        if (history.size() > MAX_HISTORY) {
            history.remove(0);
        }
    }

    public void addResponse(String response) {
        MemoryEntry entry = new MemoryEntry(response, "RESPONSE", "ai");
        history.add(entry);
        
        if (history.size() > MAX_HISTORY) {
            history.remove(0);
        }
    }

    public List<MemoryEntry> getHistory() {
        return new ArrayList<>(history);
    }

    public List<MemoryEntry> getRecentHistory(int count) {
        int start = Math.max(0, history.size() - count);
        return new ArrayList<>(history.subList(start, history.size()));
    }

    public static class MemoryEntry {
        private String content;
        private String intent;
        private String source;
        private long timestamp;

        public MemoryEntry(String content, String intent, String source) {
            this.content = content;
            this.intent = intent;
            this.source = source;
            this.timestamp = System.currentTimeMillis();
        }

        public String getContent() { return content; }
        public String getIntent() { return intent; }
        public String getSource() { return source; }
        public long getTimestamp() { return timestamp; }
    }
}
# 🤖 AI Web Builder

A powerful, intelligent AI agent web application built with Java and Spring Boot. No API keys required!

## Features

✨ **Smart AI Agent** - Understands intent and generates intelligent responses  
✨ **Code Generation** - Create code in any programming language  
✨ **Explanation Engine** - Learn programming concepts  
✨ **Debugging Helper** - Get solutions for common errors  
✨ **Optimization Tips** - Improve your code performance  
✨ **Conversation Memory** - Remembers your interaction history  
✨ **Beautiful Web UI** - Modern, responsive interface  
✨ **Zero API Keys** - Works completely offline  

## Technology Stack

- **Backend**: Java 11+, Spring Boot 3.1.5
- **Frontend**: HTML5, CSS3, Vanilla JavaScript
- **NLP**: Custom Natural Language Processing
- **Memory**: In-memory conversation history
- **Build**: Maven

## Installation & Setup

### Prerequisites
- Java 11 or higher
- Maven 3.6+

### Quick Start

```bash
# Clone the repository
git clone https://github.com/Michaelmc12372/ai-web-builder.git
cd ai-web-builder

# Build the project
mvn clean package

# Run the application
mvn spring-boot:run
```

The application will start at `http://localhost:8080`

## Usage

Open your browser and navigate to `http://localhost:8080`. Then try:

- "Generate a Java hello world program"
- "Explain what is polymorphism"
- "Help me fix a null pointer exception"
- "Optimize this code for performance"
- "Convert Python code to Java"

## Architecture

```
com.aiagent/
├── Application.java           # Spring Boot entry point
├── controller/
│   └── ChatController.java    # REST API endpoints
├── dto/
│   ├── ChatRequest.java       # Request DTO
│   └── ChatResponse.java      # Response DTO
├── core/
│   └── AIAgent.java           # Main AI logic orchestrator
├── nlp/
│   └── NLPProcessor.java      # Natural Language Processing
├── memory/
│   └── ConversationMemory.java # Conversation history
├── knowledge/
│   └── KnowledgeBase.java     # Knowledge storage
└── reasoning/
    └── ReasoningEngine.java   # Response generation
```

## API Endpoints

### POST /api/chat/message
Send a message to the AI agent.

**Request:**
```json
{
  "message": "Generate a Java program"
}
```

**Response:**
```json
{
  "message": "AI's response here",
  "success": true,
  "error": null
}
```

### GET /api/chat/health
Check if the AI agent is running.

## Key Components

### AIAgent
The core orchestrator that coordinates all components:
- Takes user input
- Processes with NLP
- Retrieves knowledge
- Generates responses
- Maintains memory

### NLPProcessor
Understands user intent:
- Intent extraction (Code generation, Explanation, Debugging, etc.)
- Entity extraction (Languages, frameworks, etc.)

### ConversationMemory
Tracks conversation history:
- Stores up to 100 interactions
- Remembers user queries and AI responses
- Provides context for better responses

### KnowledgeBase
Contains programming knowledge:
- Algorithm definitions
- Language information
- Best practices
- Design patterns

### ReasoningEngine
Generates intelligent responses:
- Uses intent and entities
- Applies knowledge context
- Formats appropriate responses

## Customization

### Add New Intents
Edit `NLPProcessor.java` and add patterns:
```java
intentPatterns.put("YOUR_INTENT", Arrays.asList("keyword1", "keyword2"));
```

### Add Knowledge
Edit `KnowledgeBase.java`:
```java
knowledge.put("KEY", "Your knowledge here");
```

### Customize Responses
Edit `ReasoningEngine.java` templates:
```java
responseTemplates.put("YOUR_INTENT", "Your template with %s placeholders");
```

## Future Enhancements

- 🚀 Machine learning model integration
- 🚀 Database persistence
- 🚀 Multi-language support
- 🚀 Advanced code analysis
- 🚀 Real-time code execution
- 🚀 User authentication
- 🚀 Chat export/sharing

## License

MIT License - Feel free to use and modify!

## Support

For issues and questions, please open an issue on GitHub.

---

**Made with ❤️ by Michaelmc12372**

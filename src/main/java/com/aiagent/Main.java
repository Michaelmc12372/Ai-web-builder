package com.aiagent;

import com.aiagent.core.AIAgent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AIAgent agent = new AIAgent();
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   🤖 AI Agent - Smart Assistant        ║");
        System.out.println("║   Type 'exit' to quit                  ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("AI: Goodbye! Thanks for chatting with me.");
                break;
            }

            if (userInput.isEmpty()) {
                continue;
            }

            String response = agent.process(userInput);
            System.out.println("AI: " + response + "\n");
        }

        scanner.close();
    }
}

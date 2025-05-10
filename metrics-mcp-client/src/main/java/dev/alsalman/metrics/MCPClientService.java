package dev.alsalman.metrics;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class MCPClientService {

    private final ChatClient client;

    public MCPClientService(ChatClient.Builder builder, ToolCallbackProvider tools) {
        this.client = builder
                .defaultToolCallbacks(tools)
                .build();
    }

    public AvailableTools listAvailableTools() {
        try {
            return client.prompt().user("What tools are available").call().entity(AvailableTools.class);
        } catch (Exception e) {
            return AvailableTools.error("Failed to retrieve available tools: " + e.getMessage());
        }
    }

    public String query(String query) {
        try {
            return client
                    .prompt()
                    .system("""
                You are a knowledgeable assistant with access to our migration from Teamcity to GitLab.
                You know about Gitlab projects, and TeamCity builds.
                You have access to the following tools:
                    - gitlab-data
                    - teamcity-data
                You can provide information about our GitLab projects, and TeamCity builds.
                """)
                    .user(query)
                    .call()
                    .content();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

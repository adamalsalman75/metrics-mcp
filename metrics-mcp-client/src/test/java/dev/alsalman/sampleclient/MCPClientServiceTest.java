package dev.alsalman.sampleclient;

import dev.alsalman.metrics.MCPClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Unit tests for MCPClientService
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MCPClientServiceTest {

    /**
     * Test successful query execution
     */
    @Test
    void testSuccessfulQuery() {
        // Arrange
        String userQuery = "Tell me about science fiction books";
        String expectedResponse = "Here are some science fiction book recommendations...";

        // Create mocks with deep stubs to handle the method chain
        ChatClient chatClient = mock(ChatClient.class, RETURNS_DEEP_STUBS);
        ChatClient.Builder builder = mock(ChatClient.Builder.class, RETURNS_DEEP_STUBS);
        ToolCallbackProvider tools = mock(ToolCallbackProvider.class);

        // Set up the builder to return our chatClient
        when(builder.defaultTools(any(ToolCallbackProvider.class))).thenReturn(builder);
        when(builder.build()).thenReturn(chatClient);

        // Set up the expected response at the end of the chain
        // This uses Mockito's deep stub feature to automatically create mocks for the entire chain
        when(chatClient.prompt().system(anyString()).user(eq(userQuery)).call().content())
            .thenReturn(expectedResponse);

        // Create the service with our mocks
        MCPClientService service = new MCPClientService(builder, tools);

        // Act
        String result = service.query(userQuery);

        // Assert
        assertEquals(expectedResponse, result);
        verify(builder).defaultTools(any(ToolCallbackProvider.class));
        verify(builder).build();
    }

    /**
     * Test error handling during query execution
     */
    @Test
    void testQueryWithException() {
        // Arrange
        String userQuery = "Tell me about science fiction books";
        String errorMessage = "An error occurred";

        // Create mocks with deep stubs
        ChatClient chatClient = mock(ChatClient.class, RETURNS_DEEP_STUBS);
        ChatClient.Builder builder = mock(ChatClient.Builder.class, RETURNS_DEEP_STUBS);
        ToolCallbackProvider tools = mock(ToolCallbackProvider.class);

        // Set up the builder to return our chatClient
        when(builder.defaultTools(any(ToolCallbackProvider.class))).thenReturn(builder);
        when(builder.build()).thenReturn(chatClient);

        // Set up the chain to throw an exception
        when(chatClient.prompt().system(anyString()).user(eq(userQuery)).call())
            .thenThrow(new RuntimeException(errorMessage));

        // Create the service with our mocks
        MCPClientService service = new MCPClientService(builder, tools);

        // Act
        String result = service.query(userQuery);

        // Assert
        assertEquals(errorMessage, result);
        verify(builder).defaultTools(any(ToolCallbackProvider.class));
        verify(builder).build();
    }
}

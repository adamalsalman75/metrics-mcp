package dev.alsalman.metrics;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MetricsMCPServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetricsMCPServerApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider getTools(TeamCityService teamCityService, GitLabService gitLabService) {
        return MethodToolCallbackProvider
                .builder()
                .toolObjects(teamCityService, gitLabService)
                .build();
    }


}

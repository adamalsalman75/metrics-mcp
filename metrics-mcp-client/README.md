# Metrics MCP Client

This module is a Spring Boot application that uses Spring AI to interact with Model Context Protocol (MCP) servers. It provides a client interface for accessing tools and services exposed by MCP servers, specifically for metrics collection from TeamCity and GitLab.

## Features

- Connects to MCP servers using the Spring AI framework
- Provides REST endpoints for accessing server functionality
- Configured to interact with the metrics-mcp-server-http module

## Endpoints

- `/query` - Accepts query parameters to request information about TeamCity builds and GitLab projects

## Configuration

- The client is configured to connect to MCP servers defined in `application.yaml`
- The client is currently configured to connect to an SSE MCP server:
  - "metrics-mcp-server-http" at http://localhost:8081
## Usage

### Prerequisites

- Java 24 or later
- Maven
- OpenAI API Key

### Running the Application

1. Export your OpenAI API key as an environment variable:
   ```bash
   export OPENAI_API_KEY=your_openai_api_key_here
   ```

   > **Important**: The application requires a valid OpenAI API key to function properly. Without this key, the application will fail to start or will not be able to process requests correctly.

2. Build the application:
   ```bash
   mvn clean package
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

   Alternatively, you can run the JAR file directly:
   ```bash
   java -jar target/metrics-mcp-client-0.0.1-SNAPSHOT.jar
   ```

4. Example Queries

### 1. "Which Teamcity projects have GitLab pipelines?"

   ```
    curl -G http://localhost:8080/query --data-urlencode "query=Which Teamcity projects have GitLab pipelines?"
   ```

**Expected Result:**

   ```
   The following TeamCity projects have associated GitLab pipelines:

1. **Payment Gateway**
   - **TeamCity Project Name:** payment-gateway
   - **GitLab Project Name:** payment-gateway
   - **GitLab URL:** [Link to Project](https://gitlab.example.com/payments/payment-gateway)
   - **TeamCity Build Configuration:** Unit Tests
   - **Build Status:** FAILURE
   - **Build Number:** 567

2. **User Service**
   - **TeamCity Project Name:** user-service
   - **GitLab Project Name:** user-service
   - **GitLab URL:** [Link to Project](https://gitlab.example.com/mortgages/user-service)
   - **TeamCity Build Configuration:** Integration Tests
   - **Build Status:** SUCCESS
   - **Build Number:** 789

These projects indicate that pipelines are set up in GitLab, corresponding to builds in TeamCity.%   
   ```


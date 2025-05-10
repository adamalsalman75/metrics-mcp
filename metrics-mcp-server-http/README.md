# Metrics MCP Server HTTP

This module is a Spring Boot application that implements a Model Context Protocol (MCP) server using HTTP and Server-Sent Events (SSE) for communication. It provides TeamCity and GitLab metrics services that can be accessed by MCP clients.

## Features

- Implements an MCP server using HTTP and SSE
- Provides TeamCity and GitLab services for collecting and analyzing CI/CD metrics
- Uses Server-Sent Events (SSE) for real-time communication with clients

## Endpoints

- `/sse` - SSE endpoint for clients to subscribe to events

## Tools

- `teamcity-service` - A tool that provides information about TeamCity builds
- `gitlab-service` - A tool that provides information about GitLab projects and pipelines

## Configuration

The server is configured as an MCP server named "metrics-mcp-server-http". It's configured to be of type SYNC and has debugging enabled for Spring AI and MCP-related components.

## Usage

### Prerequisites

- Java 24 or later
- Maven

### Running the Application

1. Build the application:
   ```bash
   mvn clean package
   ```

2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

   Alternatively, you can run the JAR file directly:
   ```bash
   java -jar target/metrics-mcp-server-http-0.0.1-SNAPSHOT.jar
   ```

3. The server will start on port 8081 by default. You can connect to it using an MCP client, such as the metrics-mcp-client module.

> **Note**: Unlike the metrics-mcp-client module, this server does not require an OpenAI API key to run.

# Metrics MCP (Model Context Protocol)

This repository contains a system for collecting and analyzing CI/CD metrics from TeamCity and GitLab using the Model Context Protocol (MCP).

## Project Structure

The repository consists of two main modules:

1. **metrics-mcp-client**: A Spring Boot application that uses Spring AI to interact with MCP servers. It provides a client interface for accessing tools and services exposed by MCP servers.

2. **metrics-mcp-server-http**: A Spring Boot application that implements an MCP server using HTTP and Server-Sent Events (SSE) for communication. It provides TeamCity and GitLab metrics services that can be accessed by MCP clients.

## How It Works

The system follows a client-server architecture:

- The **server** (metrics-mcp-server-http) exposes TeamCity and GitLab services as tools through the Model Context Protocol.
- The **client** (metrics-mcp-client) connects to the server and allows users to query information about TeamCity builds and GitLab projects using natural language.

## Prerequisites

- Java 24 or later
- Maven
- OpenAI API Key (for the client only)

## Getting Started

### 1. Start the Server

```bash
cd metrics-mcp-server-http
mvn clean package
mvn spring-boot:run
```

The server will start on port 8081 by default.

### 2. Start the Client

```bash
cd metrics-mcp-client
export OPENAI_API_KEY=your_openai_api_key_here
mvn clean package
mvn spring-boot:run
```

The client will start on port 8080 by default.

### 3. Make Queries

Once both the server and client are running, you can make queries to the client:

```bash
curl -G http://localhost:8080/query --data-urlencode "query=Which Teamcity projects have GitLab pipelines?"
```

## Documentation

For more detailed information about each module, please refer to their respective README files:

- [metrics-mcp-client README](metrics-mcp-client/README.md)
- [metrics-mcp-server-http README](metrics-mcp-server-http/README.md)


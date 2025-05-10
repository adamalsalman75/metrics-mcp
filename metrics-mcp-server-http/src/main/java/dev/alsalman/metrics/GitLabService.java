package dev.alsalman.metrics;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class GitLabService {

    private static final Logger log = LoggerFactory.getLogger(GitLabService.class);
    private final List<GitLabProject> projects = new ArrayList<>();

    @Tool(name = "gitlab-data", description = "List all data about GitLab")
    public List<GitLabProject> listProjects() {
        log.info("Listing all GitLab data");
        return projects;
    }

    @PostConstruct
    void init() {
        projects.addAll(List.of(
                new GitLabProject(
                        "user-service",
                        "user-service",
                        "User authentication and management",
                        "internal",
                        "mortgages",
                        LocalDate.now().minusYears(2),
                        "https://gitlab.example.com/mortgages/user-service",
                        "git@gitlab.example.com:mortgages/user-service.git",
                        "https://gitlab.example.com/mortgages/user-service.git",
                        3,
                        12,
                        List.of("v1", "v2"),
                        false,
                        "main",
                        5,
                        2,
                        true
                ),

                new GitLabProject(
                        "inventory-service",
                        "inventory-service",
                        "Warehouse and product inventory management",
                        "internal",
                        "products",
                        LocalDate.now().minusYears(1),
                        "https://gitlab.example.com/products/inventory-service",
                        "git@gitlab.example.com:backend/products-service.git",
                        "https://gitlab.example.com/backend/products-service.git",
                        0,
                        7,
                        List.of("v1", "v2"),
                        false,
                        "main",
                        8,
                        3,
                        false
                ),

                new GitLabProject(
                        "legacy-monolith",
                        "legacy-monolith",
                        "Original monolithic application",
                        "private",
                        "loans",
                        LocalDate.now().minusYears(5),
                        "https://gitlab.example.com/loans/legacy-monolith",
                        "git@gitlab.example.com:loans/legacy-monolith.git",
                        "https://gitlab.example.com/loans/legacy-monolith.git",
                        0,
                        3,
                        List.of("v8", "v9"),
                        false,
                        "master",
                        15,
                        1,
                        false
                ),

// New project only on GitLab
                new GitLabProject(
                        "mobile-api",
                        "mobile-api",
                        "API endpoints for mobile apps",
                        "internal",
                        "api",
                        LocalDate.now().minusMonths(2),
                        "https://gitlab.example.com/api/mobile-api",
                        "git@gitlab.example.com:api/mobile-api.git",
                        "https://gitlab.example.com/api/mobile-api.git",
                        2,
                        9,
                        List.of("v1", "v2"),
                        false,
                        "main",
                        3,
                        4,
                        true
                ),

                new GitLabProject(
                        "payment-gateway",
                        "payment-gateway",
                        "Payment processing service",
                        "private",
                        "payments",
                        LocalDate.now().minusYears(1),
                        "https://gitlab.example.com/payments/payment-gateway",
                        "git@gitlab.example.com:payments/payment-gateway.git",
                        "https://gitlab.example.com/payments/payment-gateway.git",
                        1,
                        8,
                        List.of("v0.1", "v0.2"),
                        false,
                        "main",
                        7,
                        5,
                        true
                ),

                new GitLabProject(
                        "reporting-module",
                        "reporting-module",
                        "Legacy reporting functionality",
                        "internal",
                        "mortgages",
                        LocalDate.now().minusYears(3),
                        "https://gitlab.example.com/mortgages/reporting-module",
                        "git@gitlab.example.com:mortgages/reporting-module.git",
                        "https://gitlab.example.com/mortgages/reporting-module.git",
                        0,
                        1,
                        List.of("v1", "v2"),
                        true,
                        "main",
                        0,
                        0,
                        false
                )
        ));
    }
}

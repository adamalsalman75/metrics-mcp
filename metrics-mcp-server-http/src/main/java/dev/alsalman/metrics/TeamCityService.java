package dev.alsalman.metrics;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamCityService {

    private static final Logger log = LoggerFactory.getLogger(TeamCityService.class);
    private final List<TeamCityBuild> builds = new ArrayList<>();

    @Tool(name = "teamcity-data", description = "List all TeamCity data")
    public List<TeamCityBuild> listBuilds() {
        log.info("Listing all TeamCity data");
        return builds;
    }

    @PostConstruct
    void init() {
        builds.addAll(List.of(
                new TeamCityBuild(
                        "build123",
                        "inventory-service",
                        "Deploy to Production",
                        "SUCCESS",
                        LocalDateTime.now().minusDays(1),
                        LocalDateTime.now().minusDays(1).plusHours(1),
                        "main",
                        "agent-pool-3",
                        List.of("production", "deployment"),
                        "scheduler",
                        false,
                        1245,
                        "https://teamcity.example.com/build/123",
                        65,
                        List.of("Update logging", "Fix caching issue"),
                        "/artifacts/build123",
                        "https://gitlab.example.com/products/inventory-service.git"
                ),
                new TeamCityBuild(
                        "build124",
                        "payment-gateway",
                        "Unit Tests",
                        "FAILURE",
                        LocalDateTime.now().minusDays(2),
                        LocalDateTime.now().minusDays(2).plusMinutes(45),
                        "feature/new-payment-method",
                        "agent-pool-1",
                        List.of("tests"),
                        "john.doe",
                        true,
                        567,
                        "https://teamcity.example.com/build/124",
                        45,
                        List.of("Add Stripe integration"),
                        "/artifacts/build124",
                        "https://gitlab.example.com/payments/payment-gateway.git"
                ),

                new TeamCityBuild(
                        "build125",
                        "legacy-monolith",
                        "Nightly Build",
                        "SUCCESS",
                        LocalDateTime.now().minusDays(1),
                        LocalDateTime.now().minusDays(1).plusHours(3),
                        "master",
                        "agent-pool-2",
                        List.of("nightly", "fullbuild"),
                        "scheduler",
                        false,
                        2345,
                        "https://teamcity.example.com/build/125",
                        180,
                        List.of("Various fixes", "Update dependencies"),
                        "/artifacts/build125",
                        "https://gitlab.example.com/loans/legacy-monolith.git"
                ),

                new TeamCityBuild(
                        "build126",
                        "user-service",
                        "Integration Tests",
                        "SUCCESS",
                        LocalDateTime.now().minusWeeks(2),
                        LocalDateTime.now().minusWeeks(2).plusMinutes(90),
                        "main",
                        "agent-pool-4",
                        List.of("integration", "tests"),
                        "ci",
                        false,
                        789,
                        "https://teamcity.example.com/build/126",
                        90,
                        List.of("Refactor auth logic"),
                        "/artifacts/build126",
                        "https://gitlab.example.com/mortgages/user-service.git"
                ),

                new TeamCityBuild(
                        "build127",
                        "reporting-module",
                        "Compile",
                        "SUCCESS",
                        LocalDateTime.now().minusMonths(3),
                        LocalDateTime.now().minusMonths(3).plusMinutes(25),
                        "main",
                        "agent-pool-1",
                        List.of("compile"),
                        "jane.smith",
                        false,
                        123,
                        "https://teamcity.example.com/build/127",
                        25,
                        List.of("Initial setup"),
                        "/artifacts/build127",
                        "https://gitlab.example.com/mortgages/reporting-module.git"
                )
        ));
    }
}

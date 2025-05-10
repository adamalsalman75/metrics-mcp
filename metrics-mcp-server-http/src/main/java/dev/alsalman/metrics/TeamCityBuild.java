package dev.alsalman.metrics;

import java.time.LocalDateTime;
import java.util.List;

public record TeamCityBuild(
    String buildId,
    String projectName,
    String buildConfigurationName,
    String status,
    LocalDateTime startTime,
    LocalDateTime finishTime,
    String branch,
    String agent,
    List<String> tags,
    String triggeredBy,
    boolean personal,
    int buildNumber,
    String webUrl,
    int duration,
    List<String> changes,
    String artifactsPath,
    String vcsRootUrl
) { }

package dev.alsalman.metrics;

import java.time.LocalDate;
import java.util.List;

public record GitLabProject(
    String projectName,
    String path,
    String description,
    String visibility,
    String namespace,
    LocalDate creationDate,
    String webUrl,
    String sshUrl,
    String httpUrl,
    int forkCount,
    int starCount,
    List<String> tags,
    boolean archived,
    String defaultBranch,
    int openIssuesCount,
    int openMergeRequestsCount,
    boolean hasGitlabPipelines
) {  }

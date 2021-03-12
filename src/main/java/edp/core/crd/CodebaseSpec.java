package edp.core.crd;

import lombok.Data;

@Data
public class CodebaseSpec {

    private String lang;

    private String description;

    private String framework;

    private String buildTool;

    private String strategy;

    private Repository repository;

    private Route route;

    private String testReportFramework;

    private String type;

    private String gitServer;

    private String gitUrlPath;

    private String jenkinsSlave;

    private String jobProvisioning;

    private String deploymentScript;

    private Versioning versioning;

    private String jiraServer;

    private String commitMessagePattern;

    private String ticketNamePattern;

    private String ciTool;

    private Perf perf;

    private String defaultBranch;

    private String jiraIssueMetadataPayload;

}

@Data
class Repository {
    String url;
}

@Data
class Route {
    String site;
    String path;
}

@Data
class Versioning {
    String type;
    String startFrom;
}

@Data
class Perf {
    String name;
    String[] dataSources;
}
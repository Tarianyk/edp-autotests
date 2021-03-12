package edp.core.crd;

import lombok.Data;

@Data
public class CodebaseStatus {

    private String action;

    private Boolean available;

    private String detailedMessage;

    private String value;

    private Integer failureCount;

    private String lastTimeUpdated;

    private String status;

    private String username;

    private String result;

    private String git;

}

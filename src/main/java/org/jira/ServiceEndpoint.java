package org.jira;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceEndpoint {

    GET_ISSUE("/rest/api/3/issue/{issueIdOrKey}"),
    CREATE_ISSUE("/rest/api/3/issue");

    private final String endpoint;
}

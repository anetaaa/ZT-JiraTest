package org.jira.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fields {

    private Project project;
    private IssueType issuetype;
    private int customfield_10020;
    private Reporter reporter;
    private String summary;
}

package org.jira;

import org.jira.model.CreateBody;
import org.jira.model.Fields;
import org.jira.model.IssueType;
import org.jira.model.Project;
import org.jira.model.Reporter;

public class JiraSpecification {

    public static CreateBody buildCreateBody() {
        var issueType = IssueType.builder()
                .name("Task")
                .build();

        var fields = Fields.builder()
//                .project(Project.builder()
//                        .key("ZT")
//                        .build())
                .issuetype(issueType)
                .customfield_10020(2)
                .reporter(Reporter.builder()
                        .accountId("5fd348ce8332a1010ee717a8")
                        .build())
                .summary("Automation test")
                .build();

        return CreateBody.builder()
                .fields(fields)
                .build();
    }

    public static CreateBody buildCreateBody(String issueType) {
        return CreateBody.builder()
                .fields(Fields.builder()
                        .project(Project.builder()
                                .key("ZT")
                                .build())
                        .issuetype(IssueType.builder()
                                .name(issueType)
                                .build())
                        .customfield_10020(2)
                        .reporter(Reporter.builder()
                                .accountId("5fd348ce8332a1010ee717a8")
                                .build())
                        .summary("Automation test")
                        .build())
                .build();
    }
}

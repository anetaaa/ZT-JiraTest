package org.jira;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IssueType {

    TASK("Tqask"),
    BUG("Bugq");

    private final String name;
}

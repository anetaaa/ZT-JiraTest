import org.jira.JiraService;
import org.jira.JiraSpecification;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static groovy.json.JsonOutput.toJson;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateIssueTest {

    @DisplayName("Create issue details should contain its key")
    @Test
    public void successfulCreateIssueTest() {
        var body = JiraSpecification.buildCreateBody();

        System.out.println(toJson(body));
        var response = JiraService.createIssue(toJson(body));

        System.out.println(response.asString());

        assertThat(response.getStatusCode())
                .as("The expected status code for a correctly created issue is " + SC_CREATED)
                .isEqualTo(201);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Taskq", "bug"})
    public void successfulCreateIssueByTypeTest(String issueType) {
        var body = JiraSpecification.buildCreateBody(issueType);

        System.out.println(toJson(body));
        var response = JiraService.createIssue(toJson(body));

        System.out.println(response.asString());

        assertThat(response.getStatusCode())
                .as("The expected status code for a correctly created issue is " + SC_CREATED)
                .isEqualTo(201);
    }
}

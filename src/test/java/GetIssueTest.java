import com.github.javafaker.Faker;
import org.jira.JiraService;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jira.constant.ResponseMessage.ISSUE_DOES_NOT_EXIST_OR_YOU_DO_NOT_HAVE_PERMISSION_TO_SEE_IT;
import static org.jira.constant.ResponseParameter.ERROR_MESSAGES;
import static org.jira.constant.ResponseParameter.KEY;

import org.junit.jupiter.api.DisplayName;

public class GetIssueTest {

    @DisplayName("Returned issue details should contain its key")
    @Test
    public void successfulReturnIssueDetailsTest() {
        var issueKey = "ZT-99";
        var response = JiraService.returnIssueDetails(issueKey, SC_OK);

        assertThat(response.jsonPath().getString(KEY))
                .contains(issueKey);
    }

    @DisplayName("Getting issue details for incorrect key shouldn't be possible")
    @Test
    public void unsuccessfulReturnIssueDetailsTest() {
        var issueKey = Faker.instance().name().name();
        var response = JiraService.returnIssueDetails(issueKey, SC_NOT_FOUND);

        assertThat(response.jsonPath().getString(ERROR_MESSAGES))
                .contains(ISSUE_DOES_NOT_EXIST_OR_YOU_DO_NOT_HAVE_PERMISSION_TO_SEE_IT);
    }
}
package org.jira;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;

import static io.restassured.RestAssured.given;
import static org.jira.ServiceEndpoint.CREATE_ISSUE;
import static org.jira.ServiceEndpoint.GET_ISSUE;
import static org.jira.constant.Properties.API_KEY;
import static org.jira.constant.Properties.USERNAME;
import static org.jira.constant.Request.BASE_URL;

@AllArgsConstructor
public class JiraService {

    private static final RequestSpecification requestSpecification =
            RequestSpecificationCreator.createWithCredentials(USERNAME, API_KEY, BASE_URL);

    public static Response returnIssueDetails(String issueIdOrKey, int httpStatus) {
        return given()
                .log()
                .ifValidationFails()
                .spec(requestSpecification)
                .pathParam("issueIdOrKey", issueIdOrKey)
                .when()
                .get(GET_ISSUE.getEndpoint())
                .then()
                .log()
                .ifValidationFails()
                .statusCode(httpStatus)
                .extract()
                .response();
    }

    public static Response createIssue(String body) {
        return given()
                .log()
                .ifValidationFails()
                .spec(requestSpecification)
                .body(body)
                .when()
                .post(CREATE_ISSUE.getEndpoint())
                .then()
                .log()
                .ifValidationFails()
                .extract()
                .response();
    }
}

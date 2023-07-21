package org.jira;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestSpecificationCreator {

    public static RequestSpecification createWithCredentials(String username, String apiKey, String baseUrl) {
        var requestSpecBuilder = new RequestSpecBuilder();
        var authScheme = new PreemptiveBasicAuthScheme();

        authScheme.setUserName(username);
        authScheme.setPassword(apiKey);

        requestSpecBuilder.setBaseUri(baseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setAuth(authScheme);

        return requestSpecBuilder.build();
    }
}

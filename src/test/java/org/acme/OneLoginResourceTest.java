package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.Header;
import javax.inject.Inject;
import org.acme.config.Message;
import org.acme.mockresponse.OneLoginResponseBuilder;
import org.junit.jupiter.api.Test;


@QuarkusTest
public class OneLoginResourceTest {

    @Inject
    Message message;

    @Test
    public void testGetEventEndpoint_whenAValidTokenIsPassed_returnsMockResponse() {
        var header = new Header("Authorization", "Bearer onelogin-token");
        var jsonArray = OneLoginResponseBuilder.getMockResponse();

        given()
                .header(header)
                .when().get("/onelogin/events")
                .then()
                .statusCode(200)
                .body("size()", is(4))
                .body(containsString(jsonArray.toString()));
    }

    @Test
    public void testGetEventEndpoint_whenAnInvalidValidTokenIsPassed_returnsInvalidTokenError() {
        var header = new Header("Authorization", "Bearer abc");

        given()
                .header(header)
                .when().get("/onelogin/events")
                .then()
                .statusCode(401)
                .body(is(message.error().bearerTokenIsInvalid()));
    }

    @Test
    public void testGetEventEndpoint_whenNoTokenIsPassed_returnsTokenMissingError() {
        given()
                .when().get("/onelogin/events")
                .then()
                .statusCode(401)
                .body(is(message.error().bearerTokenIsMissing()));
    }

}
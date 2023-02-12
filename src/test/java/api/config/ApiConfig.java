package api.config;

import api.dto.request.User;
import api.utils.JsonUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import static api.config.PropertiesController.getPropertyFromPlatformFile;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class ApiConfig {

    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT = "Content-Type";
    private static final String ACCEPT = "Accept";
    private static final String X_REQUEST = "X-Request-With";
    private static final String XMLHttpRequest = "XMLHttpRequest";
    private static final String URL = String.valueOf(getPropertyFromPlatformFile("url.api"));
    private static final String USERNAME = String.valueOf(getPropertyFromPlatformFile("username.api"));
    private static final String PASSWORD = String.valueOf(getPropertyFromPlatformFile("password.api"));


    public RequestSpecification request() {
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setBasePath("v2")
                .addHeader(CONTENT, APPLICATION_JSON)
                .addHeader(ACCEPT, APPLICATION_JSON)
                .addHeader(X_REQUEST, XMLHttpRequest)
                .build();
    }

    public RequestSpecification requestAuth() {
        return new RequestSpecBuilder()
                .addHeader(CONTENT, APPLICATION_JSON)
                .addHeader("Authorization", "Bearer " + getToken())
                .addHeader(ACCEPT, APPLICATION_JSON)
                .addHeader(X_REQUEST, XMLHttpRequest)
                .build();
    }

    public RequestSpecification requestAuthWithUrlencoded() {
        return new RequestSpecBuilder()
                .addHeader(CONTENT, APPLICATION_JSON)
                .addHeader("Authorization", "Bearer " + getTokenWithUrlencoded())
                .addHeader(ACCEPT, APPLICATION_JSON)
                .addHeader(X_REQUEST, XMLHttpRequest)
                .build();
    }

    private String getToken() {
        Response response =
                given()
                        .spec(request())
                        .body(JsonUtils.toJson(User.builder().username(USERNAME).password(PASSWORD).build()))
                        .when()
                        .post()
                        .then()
                        .contentType(ContentType.JSON)
                        .extract().response();

        return response.path("data.token");
    }

    private String getTokenWithUrlencoded() {
        Response response =
                given()
                        .spec(requestUrlencoded())
                        .body(format("grant_type=password&username=%s&password=%s", USERNAME, PASSWORD))
                        .when()
                        .post("/sso/oauth/token")
                        .then()
                        .contentType(ContentType.JSON)
                        .extract().response();

        return response.path("access_token");
    }

    private RequestSpecification requestUrlencoded() {
        return new RequestSpecBuilder()
                .setBasePath("/uat")
                .addHeader(CONTENT, APPLICATION_JSON)
                .addHeader("Authorization", "Basic dWk6dWltYW4=")
                .addHeader(CONTENT, "application/x-www-form-urlencoded")
                .build();
    }

    public ResponseSpecification responseOk() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public ResponseSpecification responseNotFound() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }

    public ResponseSpecification responseUnauthorized() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_UNAUTHORIZED)
                .build();
    }

    public ResponseSpecification responseNoContent() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NO_CONTENT)
                .build();
    }

    public ResponseSpecification responseBadRequest() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }

    public ResponseSpecification responseAccepted() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_ACCEPTED)
                .build();
    }

    public ResponseSpecification responseUnProcessableEntity() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)
                .build();
    }

    public ResponseSpecification responseCreated() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .build();
    }
}
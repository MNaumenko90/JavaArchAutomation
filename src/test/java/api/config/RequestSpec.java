package api.config;

import api.config.endpoints.UserConfig;
import api.dto.request.GenerateTokenRequestDto;
import api.dto.response.GenerateTokenResponseDto;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

import static api.config.ResponseSpec.ok;
import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.METHOD;
import static io.restassured.filter.log.LogDetail.PARAMS;
import static io.restassured.filter.log.LogDetail.URI;
import static io.restassured.http.ContentType.JSON;
import static java.lang.String.format;
import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;

public class RequestSpec extends Requests {

    private static final UserConfig config = create(UserConfig.class, getProperties());
    private static final String URL = config.url();
    private static String token = null;


    public static RequestSpecification request() {
        return baseSpecRequest();
    }

    public static RequestSpecification commonSpecRequest() {
        return baseSpecRequest().header(getAccessToken());

    }

    public static RequestSpecification baseSpecRequest() {
        return given()
                .filters(new RequestLoggingFilter(METHOD),
                        new RequestLoggingFilter(URI),
                        new RequestLoggingFilter(BODY))
                .relaxedHTTPSValidation()
                .baseUri(URL)
                .accept(JSON)
                .contentType(JSON);
    }

    private static Header getAccessToken() {
        Header header = null;
        if (token == null) {
            token = getToken();
            header = new Header("Authorization", format("Bearer %s", token));
        }
        return header;
    }

    private static String getToken() {
        return postForToken(generateTokenRequestDto(), config.generateToken())
                .spec(ok()).extract().as(GenerateTokenResponseDto.class).getToken();
    }

    private static GenerateTokenRequestDto generateTokenRequestDto() {
        return GenerateTokenRequestDto.builder()
                .userName(config.username())
                .password(config.password())
                .build();
    }

}
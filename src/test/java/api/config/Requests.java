package api.config;

import io.restassured.response.ValidatableResponse;

import static api.config.RequestSpec.commonSpecRequest;
import static api.config.RequestSpec.request;

public class Requests{

    public static <T> ValidatableResponse post(T body, String endpoint) {
        return commonSpecRequest().body(body).post(endpoint).then();
    }

    public static <T> ValidatableResponse postForToken(T body, String endpoint) {
        return request().body(body).post(endpoint).then();
    }

    public static ValidatableResponse get(String path, Object ...params) {
        return commonSpecRequest().get(path, params).then();
    }

    public static ValidatableResponse delete(String path, Object ...params) {
        return commonSpecRequest().get(path, params).then();
    }

    public static <T> ValidatableResponse put(T body, String endpoint) {
        return commonSpecRequest().body(body).post(endpoint).then();
    }

}

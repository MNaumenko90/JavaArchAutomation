package api.config;

import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static api.config.RequestSpec.commonSpecRequest;

public class Requests{

    public static <T> ValidatableResponse post(T body, String endpoint, Object ...params) {
        return commonSpecRequest().body(body).post(endpoint, params).then();
    }

    public static <T, H> ValidatableResponse post(Map<String, H> headers, T body, String endpoint, Object ...params) {
        return commonSpecRequest().headers(headers).body(body).post(endpoint, params).then();
    }

    public static ValidatableResponse get(String path, Object ...params) {
        return commonSpecRequest().get(path, params).then();
    }

    public static ValidatableResponse delete(String path, Object ...params) {
        return commonSpecRequest().get(path, params).then();
    }

    public static <T> ValidatableResponse put(T body, String endpoint, Object ...params) {
        return commonSpecRequest().body(body).post(endpoint, params).then();
    }

    public static <T, H> ValidatableResponse put(Map<String, H> headers, T body, String endpoint, Object ...params) {
        return commonSpecRequest().headers(headers).body(body).post(endpoint, params).then();
    }

}

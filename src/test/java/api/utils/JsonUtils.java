package api.utils;

import com.google.gson.Gson;
import io.qameta.allure.Step;

public class JsonUtils {

    private JsonUtils() {
        throw new IllegalStateException("This is utility class!");
    }

    @Step("Convert object {object} to json")
    public static  <T> String toJson(T object) {
        return new Gson().toJson(object);
    }
}

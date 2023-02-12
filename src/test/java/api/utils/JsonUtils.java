package api.utils;

import com.google.gson.Gson;

public class JsonUtils {

    private JsonUtils() {
        throw new IllegalStateException("This is utility class!");
    }

    public static  <T> String toJson(T object) {
        return new Gson().toJson(object);
    }
}

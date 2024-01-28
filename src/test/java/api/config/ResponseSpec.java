package api.config;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class ResponseSpec {

    public static ResponseSpecification ok() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }
    public ResponseSpecification notFound() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }

    public ResponseSpecification unauthorized() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_UNAUTHORIZED)
                .build();
    }

    public ResponseSpecification noContent() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NO_CONTENT)
                .build();
    }

    public ResponseSpecification badRequest() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }

    public ResponseSpecification accepted() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_ACCEPTED)
                .build();
    }

    public ResponseSpecification unProcessableEntity() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)
                .build();
    }

    public ResponseSpecification Created() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .build();
    }
}

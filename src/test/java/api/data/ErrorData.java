package api.data;

import api.dto.ErrorBody;
import api.dto.ErrorResponse;

public class ErrorData {

    private ErrorData() {
        throw new IllegalStateException("This is utility class!");
    }

    private static ErrorResponse NotFound() {
        return new ErrorResponse(ErrorBody
                .builder()
                .error("Not Found")
                .code("404")
                .build());
    }

}

package api.steps;

import api.config.ApiConfig;
import api.dto.request.CreatePetStoreRequest;
import api.dto.response.CreatePetStoreResponse;
import api.enumeration.Urls;
import api.utils.JsonUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PetOrderSteps extends ApiConfig {

    @Step("Create order in pet store")
    public void createOrder(CreatePetStoreRequest requestOrder) {
         Response response = given()
                    .spec(request())
                    .body(JsonUtils.toJson(requestOrder))
                    .when()
                    .post(Urls.CREATE_PET_STORE_ORDER.getUrl())
                    .then()
                    .spec(responseOk())
                    .extract().response();

        assertThat(response.getBody().asString())
                .isEqualTo(JsonUtils.toJson(CreatePetStoreResponse.builder().id(123).petId(32).quantity(32).complete(false)
                        .build()));
    }
}

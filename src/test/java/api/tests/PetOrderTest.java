package api.tests;

import api.dto.request.CreatePetStoreRequest;
import api.steps.PetOrderSteps;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class PetOrderTest {

    @Test
    @Description("Create order into per store using free api")
    public void createOrderIntoPetStore() {
        new PetOrderSteps()
                .createOrder(CreatePetStoreRequest.builder().id(123).petId(32).quantity(32).build());
    }
}

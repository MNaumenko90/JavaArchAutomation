package api.tests;

import api.dto.request.CreatePetStoreRequest;
import api.steps.PetOrderSteps;
import org.testng.annotations.Test;

public class PetOrderTest {

    @Test
    public void createOrderIntoPetStore() {
        new PetOrderSteps()
                .createOrder(CreatePetStoreRequest.builder().id(123).petId(32).quantity(32).build());
    }
}

package api.tests;

import api.dto.response.user.GetUserResponseDto;
import api.steps.UserSteps;
import org.testng.annotations.Test;

public class UserTest {

    private final UserSteps userSteps = new UserSteps();

    @Test
    void shouldUserBeVisible() {
        GetUserResponseDto user = userSteps.getUser();

        System.out.println(user);
    }
}

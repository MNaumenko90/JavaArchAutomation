package api.steps;

import api.config.endpoints.UserConfig;
import api.dto.response.user.GetUserResponseDto;

import static api.config.Requests.get;
import static api.config.ResponseSpec.ok;
import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;

public class UserSteps {

    private final UserConfig config = create(UserConfig.class, getProperties());

    public GetUserResponseDto getUser() {
        return get(config.getUser(), config.userId())
                .spec(ok()).extract().as(GetUserResponseDto.class);
    }
}

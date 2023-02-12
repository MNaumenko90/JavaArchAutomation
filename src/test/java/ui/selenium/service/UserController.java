package ui.selenium.service;

import ui.selenium.entities.User;

import static ui.selenium.utils.Utils.getProperty;

public class UserController {

    private UserController() {}

    public static User getUserCredentials() {
        return new User(String.valueOf(getProperty("username")),
                String.valueOf(getProperty("password")));
    }
}

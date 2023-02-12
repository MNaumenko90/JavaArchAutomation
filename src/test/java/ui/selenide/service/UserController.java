package ui.selenide.service;

import ui.selenide.entities.User;

import static ui.selenide.utils.Utils.getProperty;

public class UserController {

    private UserController() {}

    public static User getUserCredentials() {
        return new User(String.valueOf(getProperty("username")),
                String.valueOf(getProperty("password")));
    }
}

package ui.selenide.tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.selenide.configuration.base.Base;
import ui.selenide.entities.User;
import ui.selenide.po.LoginPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static ui.selenide.service.UserController.getUserCredentials;
import static ui.selenide.utils.Utils.getProperty;

public class WikiLoginTest extends Base {

    @Test
    @Description("Test for successfully auth with user")
    public void wikiLogInTest() {
        User user = getUserCredentials();

        int a;

        int b;



        new LoginPage()
                .clickLogin()
                .auth(user);

        assertThat(new LoginPage().getUsername()).isEqualTo(getProperty("username"));
    }
}

package ui.selenide.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.selenide.entities.User;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    SelenideElement login = $x("//input[@id='wpName1']");

    SelenideElement password = $x("//input[@id='wpPassword1']");

    SelenideElement enter = $x("//button[@value='Log in']");

    SelenideElement loginButton = $x("//li[@id='pt-login-2']//span");

    SelenideElement getUsername = $x("//li[@id='pt-userpage-2']//span");

    @Step("Auth user")
    public LoginPage auth(User user) {
        login.shouldBe(visible, enabled).sendKeys(user.getUsername());
        password.shouldBe(visible, enabled).sendKeys(user.getPassword());
        enter.shouldBe(visible, enabled).click();
        return page(new LoginPage());
    }

    @Step("Click login button")
    public LoginPage clickLogin() {
        loginButton.shouldBe(visible, enabled).click();
        return page(new LoginPage());
    }

    @Step("Get user's username")
    public String getUsername() {
        return getUsername.getText();
    }
}

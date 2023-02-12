package ui.selenium.po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ui.selenium.entities.User;

public class LoginPage extends BaseMethods {

    private final By login = By.xpath("//input[@id='wpName1']");

    private final By password = By.xpath("//input[@id='wpPassword1']");

    private final By enter = By.xpath("//button[@value='Log in']");

    private final By loginButton = By.xpath("//li[@id='pt-login-2']//span");

    private final By getUsername = By.xpath("//li[@id='pt-userpage-2']//span");

    @Step("Auth user")
    public LoginPage auth(User user) {
        sendKeys(login, user.getUsername());
        sendKeys(password, user.getPassword());
        click(enter);
        return this;
    }

    @Step("Click login button")
    public LoginPage clickLogin() {
        click(loginButton);
        return this;
    }

    @Step("Get user's username")
    public String getUsername() {
        return getText(getUsername);
    }
}

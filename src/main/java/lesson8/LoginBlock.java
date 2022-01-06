package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginBlock {

    private SelenideElement loginInput = $(By.id("LoginForm_email"));

    @Step("Ввести логин")
    public LoginBlock fillLoginInput(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    private SelenideElement passwordInput = $(By.id("LoginForm_password"));

    @Step("Ввести пароль")
    public LoginBlock fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    private SelenideElement sumbitLoginButton = $(By.xpath("//button[.='Войти']"));

    @Step("Нажать на кнопку Войти")
    public MainPage submitLogin() {
        sumbitLoginButton.click();
        return page(MainPage.class);
    }
}

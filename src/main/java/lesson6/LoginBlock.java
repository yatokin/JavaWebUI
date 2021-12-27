package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginBlock extends BaseView {

    public LoginBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "LoginForm_email")
    private WebElement loginInput;

    @Step("Ввести логин")
    public LoginBlock fillLoginInput(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @FindBy(id = "LoginForm_password")
    private WebElement passwordInput;

    @Step("Ввести пароль")
    public LoginBlock fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//button[.='Войти']")
    private WebElement sumbitLoginButton;

    @Step("Нажать на кнопку Войти")
    public MainPage submitLogin() {
        sumbitLoginButton.click();
        return new MainPage(driver);
    }
}


package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginBlock extends BaseView {

    public LoginBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "LoginForm_email")
    private WebElement loginInput;

    public LoginBlock fillLoginInput(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @FindBy(id = "LoginForm_password")
    private WebElement passwordInput;

    public LoginBlock fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//button[.='Войти']")
    private WebElement sumbitLoginButton;

    public MainPage submitLogin() {
        sumbitLoginButton.click();
        return new MainPage(driver);
    }
}


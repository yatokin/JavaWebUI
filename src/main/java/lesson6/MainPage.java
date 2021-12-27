package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView{

    @FindBy (xpath = "//a[.='Войти']")
    WebElement loginButton;

    @Step("Клик на кнопку Логин")
    public MainPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    @FindBy(xpath = "//a[text()='Спорт']")
    WebElement sportButton;

    @Step("Клик на кнопку Спорт")
    public SportPage clickSportButton(){
        sportButton.click();
        return new SportPage(driver);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}

package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView{

    @FindBy (xpath = "//a[.='Войти']")
    WebElement loginButton;

    public MainPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    @FindBy(xpath = "//a[text()='Спорт']")
    WebElement sportButton;

    public SportPage clickSportButton(){
        sportButton.click();
        return new SportPage(driver);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}

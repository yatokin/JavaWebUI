package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private SelenideElement loginButton = $(By.xpath("//a[.='Войти']"));

    @Step("Клик на кнопку Логин")
    public MainPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    private SelenideElement sportButton = $ (By.xpath("//a[text()='Спорт']"));

    @Step("Клик на кнопку Спорт")
    public SportPage clickSportButton(){
        sportButton.click();
        return page(SportPage.class);
    }
}

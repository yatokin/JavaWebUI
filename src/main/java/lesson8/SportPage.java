package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SportPage {

    private SelenideElement myEvent = $(By.xpath("//a[@title='Союз Чемпионов']"));

    @Step("Выбрать мероприятие Союз Чемпионов")
    public SportPage chooseEvent(){
        myEvent.click();
        return this;
    }

    private SelenideElement selection = $(By.xpath("//a[@id='js_choose_ticket']"));

    @Step("Перейти к выбору билетов")
    public SportPage goToTicketSelection(){
        selection.click();
        return this;
    }

    private SelenideElement selectSector = $(By.xpath("//a[@id='sector_limited_8269306']"));

    @Step("Перейти к выбору сектора")
    public SportPage sectorSelection(){
        selectSector.click();
        return this;
    }

    private SelenideElement selectPlace = $(By.cssSelector("#svg-inner > svg:nth-child(1) > g:nth-child(1) > polygon:nth-child(991)"));

    @Step("Перейти к выбору места")
    public SportPage placeSelection(){
        selectPlace.click();
        return this;
    }

    private SelenideElement buyButton = $(By.xpath("//a[@class='btn btn-primary btn-lg pull-right add-to-cart-btn']"));

    @Step("Нажать на кнопку Оформить заказ")
    public SportPage buyingTicket(){
        buyButton.click();
        return this;
    }

    private SelenideElement removeButton = $(By.xpath("//a[@class='icon icon-delete remove cart-remove-ticket']"));

    @Step("Удалить билет из корзины")
    public SportPage removeTicket(){
        removeButton.click();
        return this;
    }

    private SelenideElement deleteButton = $(By.xpath("//button[.='Удалить']"));

    @Step("Нажать кнопку Удалить")
    public SportPage deleteTicket(){
        deleteButton.click();
        return this;
    }
}

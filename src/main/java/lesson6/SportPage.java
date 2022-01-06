package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SportPage extends BaseView{

    public SportPage(WebDriver driver) {
        super(driver);
    }

    private final static String EVENT_XPATH_LOCATOR = "//a[@title='Союз Чемпионов']";
    @FindBy(xpath = EVENT_XPATH_LOCATOR)
    WebElement myEvent;

    @Step("Выбрать мероприятие Союз Чемпионов")
    public SportPage chooseEvent(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EVENT_XPATH_LOCATOR)));
        myEvent.click();
        return this;
    }

    @FindBy(xpath = "//a[@id='js_choose_ticket']")
    WebElement selection;

    @Step("Перейти к выбору билетов")
    public SportPage goToTicketSelection(){
        selection.click();
        return this;
    }

    @FindBy(xpath = "//a[@id='sector_limited_8269306']")
    WebElement selectSector;

    @Step("Перейти к выбору сектора")
    public SportPage sectorSelection(){
        selectSector.click();
        return this;
    }

    private final static String PLACE_CSS_SELECTOR =
            "#svg-inner > svg:nth-child(1) > g:nth-child(1) > polygon:nth-child(991)";
    @FindBy(how = How.CSS, using = PLACE_CSS_SELECTOR)
    WebElement selectPlace;

    @Step("Перейти к выбору места")
    public SportPage placeSelection(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PLACE_CSS_SELECTOR)));
        selectPlace.click();
        return this;
    }

    private final static String BUY_BUTTON_XPATH_LOCATOR =
            "//a[@class='btn btn-primary btn-lg pull-right add-to-cart-btn']";
    @FindBy(xpath = BUY_BUTTON_XPATH_LOCATOR)
    WebElement buyButton;

    @Step("Нажать на кнопку Оформить заказ")
    public SportPage buyingTicket(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUY_BUTTON_XPATH_LOCATOR)));
        buyButton.click();
        return this;
    }

    @FindBy(xpath = "//a[@class='icon icon-delete remove cart-remove-ticket']")
    WebElement removeButton;

    @Step("Удалить билет из корзины")
    public SportPage removeTicket(){
        removeButton.click();
        return this;
    }

    private final static String DELETE_BUTTON_XPATH_LOCATOR = "//button[.='Удалить']";
    @FindBy(xpath = DELETE_BUTTON_XPATH_LOCATOR)
    WebElement deleteButton;

    @Step("Нажать кнопку Удалить")
    public SportPage deleteTicket(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DELETE_BUTTON_XPATH_LOCATOR)));
        deleteButton.click();
        return this;
    }

}

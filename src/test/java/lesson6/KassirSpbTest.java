package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import lesson7.CustomLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;

public class KassirSpbTest<driver> {
    WebDriver driver;
    EventFiringWebDriver eventFiringWebDriver;
    MainPage mainPage;
    LoginBlock loginBlock;
    private final static String BASE_URL = "https://spb.kassir.ru/";
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        eventFiringWebDriver = new EventFiringWebDriver(new ChromeDriver());
//        driver = new ChromeDriver();
        eventFiringWebDriver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(eventFiringWebDriver, 5);
        actions = new Actions(eventFiringWebDriver);
        mainPage = new MainPage(eventFiringWebDriver);
        loginBlock = new LoginBlock(eventFiringWebDriver);
        eventFiringWebDriver.get(BASE_URL);
    }

    @Test
    @Description("Тест Добавление билета в корзину")
    public void addTicketToBasketTest() throws InterruptedException {
        new MainPage(eventFiringWebDriver).clickLoginButton();
        Thread.sleep(5000);

        new LoginBlock(eventFiringWebDriver)
                .fillLoginInput("yatokinmi@yandex.ru")
                .fillPasswordInput("kassirtest")
                .submitLogin();
        Thread.sleep(5000);

        new MainPage(eventFiringWebDriver).clickSportButton();
        Thread.sleep(5000);

        new SportPage(eventFiringWebDriver)
                .chooseEvent()
                .goToTicketSelection()
                .sectorSelection()
                .placeSelection()
                .buyingTicket()
                .removeTicket()
                .deleteTicket();
    }

    @AfterEach
    void tearDown() {
        LogEntries logs = eventFiringWebDriver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logs.iterator();

        while (iterator.hasNext()) {
            Allure.addAttachment("Элемент лога браузера", iterator.next().getMessage());

            eventFiringWebDriver.quit();
        }

    }
}

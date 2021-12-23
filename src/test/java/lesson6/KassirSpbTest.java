package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KassirSpbTest<driver> {
    WebDriver driver;
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
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        mainPage = new MainPage(driver);
        loginBlock = new LoginBlock(driver);
        driver.get(BASE_URL);
    }

    @Test
    public void addTicketToBasketTest() throws InterruptedException {
        new MainPage(driver).clickLoginButton();
        Thread.sleep(5000);

        new LoginBlock(driver)
                .fillLoginInput("yatokinmi@yandex.ru")
                .fillPasswordInput("kassirtest")
                .submitLogin();
        Thread.sleep(5000);

        new MainPage(driver).clickSportButton();
        Thread.sleep(5000);

        new SportPage(driver)
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
        driver.quit();
    }

}

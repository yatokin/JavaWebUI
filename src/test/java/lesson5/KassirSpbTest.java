package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class KassirSpbTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private static final String BASE_URL = "https://spb.kassir.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    }

    @Test
    public void login() throws InterruptedException {
        driver.findElement(By.xpath("//a[.='Войти']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("LoginForm_email")).sendKeys("yatokinmi@yandex.ru");
        driver.findElement(By.id("LoginForm_password")).sendKeys("kassirtest");
        driver.findElement(By.xpath("//button[.='Войти']")).click();
        Thread.sleep(10000);
    }

    @Test
    public void addTicketToBasket() throws InterruptedException {
        login();

        driver.findElement(By.xpath("//a[text()='Спорт']")).click();
        driver.findElement(By.xpath("//div[@data-item-id='1377968']")).click();
        Thread.sleep(10000);
//        driver.findElement(By.id("js_choose_ticket")).click();
//        Thread.sleep(10000);
        driver.findElement(By.id("sector_limited_79192")).click();
        Thread.sleep(20000);
        driver.findElement(By.cssSelector("#svg-inner > svg > g > polygon:nth-child(593)")).click();
//        driver.findElement(By.xpath("@id=\"svg-inner\"]/svg/g/polygon[295]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-lg pull-right add-to-cart-btn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='icon icon-delete remove cart-remove-ticket']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[.='Удалить']")).click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
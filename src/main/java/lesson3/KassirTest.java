package lesson3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class KassirTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://spb.kassir.ru/");
        driver.findElement(By.xpath("//a[text()='Спорт']")).click();
        driver.findElement(By.xpath("//div[@data-item-id='1377968']")).click();
        driver.findElement(By.id("js_choose_ticket")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("sector_limited_79176")).click();
        Thread.sleep(20000);
        driver.findElement(By.id("sector_window")).click();
        driver.quit();
    }
}

package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SkyScanner {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.skyscanner.ru");
        driver.findElement(By.id("fsc-destination-search")).sendKeys("Москва");
        driver.findElement(By.id("return-fsc-datepicker-button")).click();
        driver.findElement(By.xpath("//*[@id=\"return-fsc-datepicker-popover\"]/div/div/div[2]/div/table/tbody/tr[5]/td[4]/button/span")).click();
        driver.findElement(By.id("flights-search-controls-root")).click();


    }
}

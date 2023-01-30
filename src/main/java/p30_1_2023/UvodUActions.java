package p30_1_2023;

//import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UvodUActions {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");
        WebElement httpTraffic =  driver.findElement(By.xpath("//*[contains(text(), 'HTTP Traffic')]"));

//        Actions actions = new Actions(driver);
//        actions.scrollToElement(httpTraffic);
//        actions.perform();

        //skraceno:
        new Actions(driver).scrollToElement(httpTraffic).perform();

        Thread.sleep(5000);
        driver.quit();
    }
}

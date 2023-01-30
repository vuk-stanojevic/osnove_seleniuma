package p30_1_2023;

//import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UvodUEksplicitno {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("file:///C:/Users/Vuk/Desktop/Zadatak4.html");

        driver.findElement(By.id("showInBtn")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-0")));

//        wait.until(ExpectedConditions.urlContains("/profile"));
//        wait.until(ExpectedConditions.titleContains("Profile page"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("showInBtn")));
//        driver.findElement(By.id("showInBtn")).click();

        //cekas dok youtube ne predje u dark mode
        wait.until(ExpectedConditions.attributeContains(By.tagName("html"), "dark", ""));

        System.out.println("Nastavak, element je ispunio uslov");

        Thread.sleep(5000);
        driver.quit();
    }
}

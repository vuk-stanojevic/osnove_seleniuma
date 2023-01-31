package p31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//        1. Napisati program koji:
//Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//U folder skinite i postavite proizvoljnu sliku
//Ucitava stranu https://tus.io/demo.html
//Skrola do dela za upload fajla
//Aploadujte sliku
//Cekajte da se pojava dugme za download fajla

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://tus.io/demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement uploadButton = driver.findElement(By.id("js-file-input"));

        actions.scrollToElement(uploadButton).perform();
        uploadButton.sendKeys(new File("test_data/lion.jpg").getAbsolutePath());

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@class, 'button')]"))));

        Thread.sleep(5000);
        driver.quit();
    }
}

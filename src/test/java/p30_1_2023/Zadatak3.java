package p30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        3.Zadatak
//Napisati program koji
//ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Klik Primary dugme
//Ceka da se pojavi toasts u gornjem desnom uglu
//Ispisuje da se element pojavio
//Ceka da se izgubi toasts u gornjem desnom uglu
//Ispisuje da se elment izgubio
//Klik na primary dugme
//Ceka da se pojavi toasts u gornjem desnom uglu
//Ispisuje da se element pojavio
//Klik na x dugme iz toasts-a
//Ceka da se element izgubi
//Ispisuje da se element izgubio


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement primaryButton = driver.findElement(By.xpath("//button[contains(@id, 'primary')]"));
        wait.until(ExpectedConditions.elementToBeClickable(primaryButton));
        primaryButton.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id, 'basic')]"))));
        System.out.println("Element se pojavio");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@id, 'basic')]"))));
        System.out.println("Element se izgubio");

        primaryButton.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id, 'basic')]"))));
        System.out.println("Element se pojavio");
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@id, 'basic')]"))));
        System.out.println("Element se izgubio");

        System.out.println("Stranica je ucitana");
        Thread.sleep(5000);
        driver.quit();
    }
}

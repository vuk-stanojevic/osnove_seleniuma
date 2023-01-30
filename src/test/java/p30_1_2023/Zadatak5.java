package p30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
//5.Zadatak
//Napisati program koji:
//Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//Ceka da broj toasts-a bude 4
//Ispisuje poruku, toasts su prikazani
//Ceka da broj toasts-a bude 0
//Ispisuje poruku, toasts su se izgubili

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@id, 'primary')]")));
        driver.findElement(By.xpath("//button[contains(@id, 'primary')]")).click();
        driver.findElement(By.xpath("//button[contains(@id, 'secondary')]")).click();
        driver.findElement(By.xpath("//button[contains(@id, 'success')]")).click();
        driver.findElement(By.xpath("//button[contains(@id, 'danger')]")).click();

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(@id, 'basic')]"), 3));
        System.out.println("Toasts su prikazani");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@id, 'basic')]"))));
        System.out.println("Toasts su se izgubili");

        System.out.println("Stranica je ucitana");
        Thread.sleep(5000);
        driver.quit();
    }
}

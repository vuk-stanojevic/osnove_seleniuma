package domaci_31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak4ZaVezbanje {
    public static void main(String[] args) throws InterruptedException {
//        4. Zadatak (za vezbanje)
//    Napisati program koji:
//Ucitava stranicu https://blueimp.github.io/jQuery-File-Upload/
//Uploaduje sve cetiri slike odjenom (slike iz prvog zadatka)
//Ceka da se prikazu 4 item-a a upload
//Klik na upload
//Ceka da se upload zavrsi

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement uploadButton = driver.findElement(By.xpath("//input[@type='file']"));

//        https://sqa.stackexchange.com/questions/38475/how-to-add-multiple-files-in-selenium-web-driver-using-java/38482#38482
        String fajl1 = new File("test_data/front.jpg").getAbsolutePath();
        String fajl2 = new File("test_data/left.jpg").getAbsolutePath();
        String fajl3 = new File("test_data/back.jpg").getAbsolutePath();
        String fajl4 = new File("test_data/right.jpg").getAbsolutePath();
        uploadButton.sendKeys(fajl1 + "\n " + fajl2 + "\n " + fajl3 + "\n " + fajl4);

        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 4));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button[@data-type='DELETE']"), 4));

        Thread.sleep(5000);
        driver.quit();
    }
}

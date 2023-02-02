package p31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class UploadFileUvod {
    public static void main(String[] args) throws InterruptedException {

//        String uploadImgPath = new File("test_data/lion.jpg").getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("http://demo.guru99.com/test/upload/");
        driver.findElement(By.id("uploadfile_0"))
                .sendKeys(new File("test_data/lion.jpg").getAbsolutePath());

        driver.findElement(By.id("submitbutton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("res")));

        Thread.sleep(5000);
        driver.quit();
    }
}

package p31_1_2023;

import com.sun.deploy.cache.Cache;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws Exception {
//        4. Zadatak
//        Napisati program koji:
//Kreirati screenshots folder u projektu
//Ucitava stranicu https://cms.demo.katalon.com/
//Kreira screenshot stranice
//Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
//Koristan link

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cms.demo.katalon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

//        https://www.browserstack.com/guide/take-screenshots-in-selenium
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        takeSnapShot(driver,"screenshots/screenshot1.jpg");

        Thread.sleep(5000);
        driver.quit();
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile=new File(fileWithPath);
//Copy file at destination
        Cache FileUtils = null;
        FileUtils.copyFile(SrcFile, DestFile);
    }
}

package p31_1_2023;

import com.sun.deploy.cache.Cache;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Zadatak6ZaVezbanje {
    public static void main(String[] args) throws Exception {
//        6. Zadatak (Za vezbanje)
//Po tekstu zadataka 4, kreirajte screenshot i sacuvajte ga u folderu screenshots pod
// imenom screenshot-[dan]-[mesec]-[godina] [sat]-[minut]-[sekund].jpg
//Koristan link https://www.javatpoint.com/java-date-to-string

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cms.demo.katalon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

//        https://www.browserstack.com/guide/take-screenshots-in-selenium
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

//        https://www.javatpoint.com/java-date-to-string
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
        String strDate = dateFormat.format(date);

        takeSnapShot(driver,"screenshots/screenshot-" + strDate + ".jpg");


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

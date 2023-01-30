package p27_01_2023;

//import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Template {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().window().maximize();
        driver.findElement(By.id("showLargeModal")).click();

        




////        driver.findElement(By.id("showInBtn"));
//        boolean elementExist = true;
//        try {
//            WebElement div = driver.findElement(By.id("id-0"));
//            System.out.println("KDSLKSDKL");
//        } catch (NoSuchElementException error) {
//            elementExist = false;
//        }
//
//        if (elementExist) {
//            System.out.println("Element postoji");
//        } else {
//            System.out.println("Element ne postoji");
//        }
//        System.out.println("");


//        Helper helper = new Helper();
//        if (helper.elementExist(driver, By.id("id-0"))) {
//            System.out.println("Postoji");
//        } else {
//            System.out.println("Ne postoji.");
//        }


//        II NACIN
//        List<WebElement> divs= driver.findElements(By.id("id-0"));
//
//        if (divs.size() > 0) {
//            System.out.println("Postoji");
//        } else {
//            System.out.println("Ne postoji.");
//        }


//        Helper helper = new Helper();
//        if (helper.elementExistByList(driver, By.id("id-0"))) {
//            System.out.println("Postoji");
//        } else {
//            System.out.println("Ne postoji.");
//        }


//        WebElement div = driver.findElement(By.id("id-0"));
//        if (div.isDisplayed()) {
//
//        }

        Thread.sleep(5000);
        driver.quit();
    }
}

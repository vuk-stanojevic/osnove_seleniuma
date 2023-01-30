package p27_1_2023;

import com.sun.deploy.ref.Helpers;
import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Uvod {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Vuk/Desktop/Zadatak4.html");

//        driver.findElement(By.id("showInBtN"));

//        boolean elementExists = true;
//        try{
//            System.out.println("PRE TRAZENJA");
//            WebElement div = driver.findElement(By.id("id-0"));
//            System.out.println("POSLE TRAZENJA");
//
//        } catch (NoSuchElementException error) {
//            elementExists = false;
//        }
//
//        if(elementExists){
//            System.out.println("Element postoji");
//        } else {
//            System.out.println("Element ne postoji");
//        }
//
//        System.out.println("KRAJ");

////        I NACIN za proveru postojanja nekog elementa - try-catch
//        Helper helper = new Helper();
//        if(helper.elementExists(driver, By.id("id-0"))){
//            System.out.println("Postoji");
//        } else {
//            System.out.println("Ne postoji");
//        }

//        II NACIN za proveru postojanja nekog elementa (nekad moze da bude sporiji i to kad element postoji, posto opet ide
//        kroz celu strane da bi dohvatila sve takve elemente, a ne samo prvi) - puna/prazna lista
//        List<WebElement> divs = driver.findElements(By.id("id-0"));
//        if(divs.size()>0){
//            System.out.println("Postoji");
//        } else {
//            System.out.println("Ne postoji");
//        }

        Helper helper2 = new Helper();
        if(helper2.elementExistsByList(driver, By.id("id-0"))){
            System.out.println("Postoji");
        } else{
            System.out.println("Ne postoji");
        }
        Thread.sleep(5000);
        driver.quit();

    }
}

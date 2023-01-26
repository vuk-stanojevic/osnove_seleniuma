package p26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//     4. Zadatak
//Napisati program koji ucitava stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cms.demo.katalon.com/my-account/");
        System.out.println(driver.findElement(By.id("rememberme")).isSelected());
        driver.findElement(By.id("rememberme")).click();
        System.out.println(driver.findElement(By.id("rememberme")).isSelected());
        Thread.sleep(5000);
        driver.quit();
    }
}

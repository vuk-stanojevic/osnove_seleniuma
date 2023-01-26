package p26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
//6. Zadatak
//Ucitati stranicu https://cms.demo.katalon.com/
//Maksimizovati prozor
//Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
//Prostavite duzinu prozora na 700px i visinu na 700px
//Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cms.demo.katalon.com/");
        driver.manage().window().maximize();
        if(driver.findElement(By.className("menu-toggle")).isDisplayed()){
            System.out.println("Crno MENU dugme je vidljivo");
        } else {
            System.out.println("Crno MENU dugme nije vidljivo");
        }
        driver.manage().window().setSize(new Dimension(700, 700));
        if(driver.findElement(By.className("menu-toggle")).isDisplayed()){
            System.out.println("Crno MENU dugme je vidljivo");
        } else {
            System.out.println("Crno MENU dugme nije vidljivo");
        }
        Thread.sleep(5000);
        driver.quit();

    }
}

package p24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        2.Zadatak
//Napisati program koji:
//Maksimizuje prozor
//Ucitava stranicu https://demoqa.com/login
//Za username unosi itbootcamp. Xpath za trazivnje ovog elementa treba da bude preko id atributa.
//Za lozinku unosi ITBootcamp2021!  Xpath za trazenje ovog elementa treba da bude preko placeholder atributa.
//Klikce na dugme Login. Xpath ovog elementa treba da bude tako da se prvo dohvati form element i da se od njega spusti do dugmeta
//Ceka 5sekundi
//Klikce na dugme Log out.Xpath ovog elementa treba da bude po tekstu elementa. Koristan link
//Zatvara pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

//        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='userName']"));
        WebElement usernameInput = driver.findElement(By.id("userName"));
        usernameInput.sendKeys("itbootcamp");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordInput.sendKeys("ITBootcamp2021!");
//        WebElement loginButton = driver.findElement(By.xpath("//form[@id='userForm']/div[4]/div[1]/button"));
        WebElement loginButton = driver.findElement(By.xpath("//form[@id='userForm']//button[@id='login']"));
//        driver.findElement(By.id("userName")).findElement(By.id("login")).click();
        loginButton.click();
//        loginButton.sendKeys(Keys.ENTER);  //provera da li radi i ovako sa enter umesto klika
        Thread.sleep(5000);
        WebElement logoutButton = driver.findElement(By.xpath("//button[text()='Log out']"));
        logoutButton.click();
        driver.quit();
    }
}

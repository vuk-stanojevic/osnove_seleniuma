package domaci_24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
// 1. Zadatak
//Maksimizirati prozor
//Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//Prijavite se na sistem
//Username: Admin
//Password: admin123
//Cekanje od 5s
//U input za pretragu iz navigacije unesite tekst Me
//Kliknite na prvi rezultat pretrage (to ce biti Time)
//Cekanje od 1s
//Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//Klinkite na logout
//Cekanje od 5s
//Zatvorite pretrazivac


//iako su xpath-ovi i name dobri, izbacuje gresku kao da ne moze da ih nadje
//na sajtu stoji da mora da se enable-uje javascript da bi ovo radilo, a trenutno nemam vremena da pogledam
//        sta je sve potrebno i kako da se namesti da bi se to uradilo kroz driver, pa da bi onda sve moglo da radi
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//        ChromeOptions opts = new ChromeOptions();
//        opts.addArguments("--enable-javascript");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("Admin");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys("admin123");
        driver.findElement(By.className("oxd-button")).click();
        Thread.sleep(5000);
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        search.sendKeys("Me");
        driver.findElement(By.xpath("//a[contains(@href, 'Time')]")).click();
        Thread.sleep(1000);
        // nalog nam je Paul Allen, ne Paul Collings
        driver.findElement(By.xpath("//p[text()='Paul Allen']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}

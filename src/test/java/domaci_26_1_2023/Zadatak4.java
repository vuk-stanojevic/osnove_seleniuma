package domaci_26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//     4.Zadatak
//Napisati program koji ucitava stranicu https://geodata.solutions/
//Bira Country, State i City po vasoj zelji
//Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//Izabrerit Country, State i City tako da imate podatke da selektujete!

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://geodata.solutions/");


//      juce mi je radilo sve lepo, danas kad sam hteo da pustim program da proverim,
//      ne ucitava mi stranicu kroz driver i izbacuje Error 1015 You are being rate limited
        Select select = new Select(driver.findElement(By.name("country")));
        select.selectByValue("Serbia");
        Thread.sleep(1000);
        select = new Select(driver.findElement(By.name("state")));
        select.selectByValue("Central Serbia");
        Thread.sleep(1000);
        select = new Select(driver.findElement(By.name("city")));
        select.selectByValue("Nis");
        Thread.sleep(5000);
        driver.quit();
    }
}

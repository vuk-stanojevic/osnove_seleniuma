package p30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//        2. Zadatak
//Napisati program koji ucitava stranicu https://youtube.com i u search baru unosi tekste Breskvica
// i ceka da se pojavi vise od 3 rezultata iz padajuceg menija i zatim klikce na prvi

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");

//        uradjeno da ceka na treci rezultat pretrage:
//        driver.findElement(By.name("search_query")).sendKeys("breskvica");
//        driver.findElement(By.name("search_query")).sendKeys(Keys.SPACE);
//        driver.findElement(By.name("search_query")).sendKeys(Keys.ENTER);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("ytd-video-renderer"), 3));
//        driver.findElement(By.tagName("ytd-video-renderer")).click();

//        uradjeno da ceka na treci suggested search result:
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.name("search_query")).sendKeys("breskvica");
        driver.findElement(By.name("search_query")).sendKeys(Keys.SPACE);
        wait.until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath("//li[@class='sbsb_c gsfs']"), 3));
        driver.findElement(By.xpath("//li[@class='sbsb_c gsfs'][3]")).click();

        System.out.println("Stranica je ucitana");
        Thread.sleep(5000);
        driver.quit();
    }
}

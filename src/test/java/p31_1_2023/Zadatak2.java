package p31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
// 2. Zadatak
//        Napisati program koji:
//Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
//Uploadujte sliku
//Ceka se da se pojavi slika u listi uploadovanih fajlova
//Koristite uslov da broj elemenata bude 1.
//Klik na Start dugme u okviru item-a koji se uploadovao
//Ceka se da se pojavi delete dugme pored itema
//Klik na delete dugme pored itema
//Ceka se da se element obrise
//Koristite da broj elemenata bude 0


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement uploadButton = driver.findElement(By.xpath("//input[@type='file']"));

        uploadButton.sendKeys(new File("test_data/lion.jpg").getAbsolutePath());

        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 1));

        driver.findElement(By.xpath("//tr//*[contains(@class, 'glyphicon-upload')]")).click();

        WebElement delete = driver.findElement(By.xpath("//button[@data-type='DELETE']"));
        wait.until(ExpectedConditions.visibilityOf(delete));
        delete.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 1));

        Thread.sleep(5000);
        driver.quit();
    }
}

package p26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
//        5. Zadatak (dok ne stignemo do ovog zadatka izguglajte kako da selektujete vrednost u select elementu)
//(slika)
//Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
//        driver.findElement(By.xpath("//select/option[text()='Crafts']")).click();
        WebElement selectEl = driver.findElement(By.id("gh-cat"));
        Select select = new Select(selectEl);
        select.selectByVisibleText("Crafts");
        Thread.sleep(5000);
        driver.quit();

    }
}

package p30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
//6. Zadatak
//Napisati program koji:
//Ucitava stranicu https://tus.io/demo.html
//Hvata sve linkove sa stranice
//        Skrola do svakog h3 elementa
//        Od svakog h3 elementa cita text

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://tus.io/demo.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        List<WebElement> header3 = driver.findElements(By.tagName("h3"));
        for (int i = 0; i < header3.size(); i++) {
            actions.scrollToElement(header3.get(i)).perform();
            System.out.println(header3.get(i).getText());
        }
        Thread.sleep(5000);
        driver.quit();
    }
}

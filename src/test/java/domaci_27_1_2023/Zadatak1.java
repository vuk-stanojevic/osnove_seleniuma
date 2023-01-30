package domaci_27_1_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//        1.Zadatak
//Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Klik na svako dugme od PRIMARY do DARK
//Sacekati da se toasts u desnom gornjem uglu pojavi
//Pauza izmedju klikova 1s
//Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        List<WebElement> buttons = driver.findElements(By.xpath("//section[@class='p-4 d-flex justify-content-center text-center w-100']" +
                "//div[@class='container text-center']/button"));
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).click();
            Thread.sleep(1000);
            new Helper().elementExists(driver, By.xpath("//div[contains(@id, 'basic')]"));
            Thread.sleep(1000);
        }
        Thread.sleep(5000);
        driver.quit();
    }
}

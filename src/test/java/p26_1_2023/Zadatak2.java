package p26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//     2.Zadatak
//Napisti program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//Hvata sve elemente prve kolone i stampa tekst svakog elementa.
// Kako da od nekog elementa procitamo tekst imate na sledecem linku
//Ceka 1s
//Hvata sve elemente prvog reda i stampa tekst svakog elementa
//Ceka 5s
//Zatvara pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://s.bootsnipp.com/iframe/z80en");
        List<WebElement> firstColumn = driver.findElements(By.xpath("//div[@id='lorem']//td[1]"));
        for (int i = 0; i < firstColumn.size(); i++) {
            System.out.println(firstColumn.get(i).getText());
        }
        Thread.sleep(1000);
        System.out.println();
        List<WebElement> firstRow = driver.findElements(By.xpath("//div[@id='lorem']//tr[1]/td"));
        for (int i = 0; i < firstRow.size(); i++) {
            System.out.print(firstRow.get(i).getText() + "\t");
        }
        Thread.sleep(1000);
        driver.quit();
    }
}

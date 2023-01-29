package domaci_26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//    3. Zadatak
//    Napisati program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice
// i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//POMOC: Brisite elemente odozdo.
//(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> alert = driver.findElements(By.className("alert"));
        for (int i = 0; i < alert.size(); i++) {
            alert.get(i).findElement(By.className("close")).click();
            Thread.sleep(1000);
        }

//        List<WebElement> alerts = driver.findElements(By.className("alert"));
//        List<WebElement> buttons = driver.findElements(By.className("close"));
//        for (int i = 0; i < buttons.size(); i++) {
//            buttons.get(i).click();
//            Thread.sleep(1000);
//            alerts.remove(i);
//            if(!alerts.get(i).isDisplayed()){
//                System.out.println("Element je obrisan");
//            }
//        }

//        List<WebElement> alert = driver.findElements(By.className("close"));
//        for (int i = 0; i < alert.size(); i++) {
//            alert.get(alert.size()-1).findElement(By.className("close")).click();
//            Thread.sleep(1000);
//        }



        Thread.sleep(5000);
        driver.quit();

    }
}

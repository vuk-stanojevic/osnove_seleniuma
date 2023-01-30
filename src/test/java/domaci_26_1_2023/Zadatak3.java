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
        List<WebElement> alertObrisan;
        for (int i = 0; i < alert.size(); i++) {
            alert.get(i).findElement(By.className("close")).click();
            Thread.sleep(1000);
            alertObrisan = driver.findElements(By.className("alert"));
            if(alertObrisan.size()==alert.size()-i-1){
                System.out.println("Element je obrisan");
            }
        }
        Thread.sleep(5000);
        driver.quit();

    }
}

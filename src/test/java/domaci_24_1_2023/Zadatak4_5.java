package domaci_24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4_5 {
    public static void main(String[] args) throws InterruptedException {
//       4. Zadatak
//       5. Zadatak
//Maksimizirati prozor
//Ucitati stranicu https://artplayer.org/
//U fokusu je player sa desne strane
//Ceka 3-4s
//Klik na play dugme
//Klik na na zvucnik za mute
//Ceka 3s
//Klik na screenshot
//Klik na PIP mode
//Ceka 1s
//Klik na Exit PIP mode
//Klik na WebFullscreen
//Klik na Exit WebFullscreen
//Cekanje od 5s
//Zatvorite pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://artplayer.org/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@aria-label='Play']")).click();
        driver.findElement(By.xpath("//i[@aria-label='Mute']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[contains(@class, 'screenshot')]")).click();
        driver.findElement(By.xpath("//i[contains(@class, 'pip')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[contains(@class, 'pip')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[contains(@class, 'fullscreenWebOn')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//i[contains(@class, 'fullscreenWebOff')]")).click();



        Thread.sleep(5000);
        driver.quit();

    }
}

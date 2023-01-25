package domaci_24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3_4 {
    public static void main(String[] args) throws InterruptedException {
//       3. Zadatak
//       4. Zadatak
//Napisati program koji vrsi dodavanje 5 redova
//Maksimizirati prozor
//Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
//Klik na dugme Add New
//Unesite name,departmant i phone (uvek iste vrednost)
//Trazenje po name atributu
//Kliknite na zeleno Add dugme.
//PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, delete ali zbog prirode reda neki dugmici se vide a neki ne.
//Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
//Cekanje od 0.5s
//Na kraju programa ugasite pretrazivac.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
        for (int i = 0; i < 5; i++) {
            WebElement addNew = driver.findElement(By.className("add-new"));
            addNew.click();
            driver.findElement(By.name("name")).sendKeys("Marko Markovic");
            driver.findElement(By.name("department")).sendKeys("C-Suite Management");
            driver.findElement(By.name("phone")).sendKeys("(012) 345-6789");
            driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a[@class='add']")).click();
        }
        Thread.sleep(500);
        driver.quit();


    }
}

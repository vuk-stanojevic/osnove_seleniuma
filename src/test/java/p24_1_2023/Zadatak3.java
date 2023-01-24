package p24_1_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    public static void main(String[] args) {
//        3.Zadatak
//Napisati program koji ima:
//Niz stranica (niz stringova) koje treba da ucita. Niz je:
//https://google.com/
//https://youtube.com/
//https://www.ebay.com/
//https://www.kupujemprodajem.com/
//Program petljom prolazi kroz niz stranica i svaku stranicu ucitava preko get ili navigate i od svake stranice na ekranu ispisuje naslov stranice. Kako od stranice procitati naslov imate na ovom linku
//U prevodu u konzoli treba da se ispisu:
//Google
//YouTube
//Electronics, Cars, Fashion, Collectibles & More | eBay
//KupujemProdajem
//Zatvara pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ArrayList<String> stranice = new ArrayList<>();
        stranice.add("https://google.com/");
        stranice.add("https://youtube.com/");
        stranice.add("https://www.ebay.com/");
        stranice.add("https://www.kupujemprodajem.com/");
        for (int i = 0; i < stranice.size(); i++) {
            driver.get(stranice.get(i));
            System.out.println(driver.getTitle());
        }
        driver.quit();
    }
}

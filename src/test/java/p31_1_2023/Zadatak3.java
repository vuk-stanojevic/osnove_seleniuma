package p31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//        3. Zadatak
//Napisati program koji
//Kreirati folder downloads folder u projektu
//Ucitava stranu https://cms.demo.katalon.com/product/flying-ninja/
//Cita href atribut sa glavne slike sa stranice
//Koristi link iz href atributa za skidanje slike
//Sliku sacuvajte u folderu downloads pod nazivom flying-ninja.jpg
//Koristan link za skidanje fajlova u javi
//Azurirajte gitignore da ignorise downloads folder

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cms.demo.katalon.com/product/flying-ninja/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String href = driver.findElement(By.xpath("//figure/div[1]/a")).getAttribute("href");

//        https://www.digitalocean.com/community/tutorials/java-download-file-url
        try {
            downloadUsingStream(href, "downloads/poster_2_up.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
        driver.quit();
    }
    private static void downloadUsingStream(String href, String file) throws IOException {
        URL url = new URL(href);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
}

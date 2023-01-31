package p31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        5. Zadatak
//        Napisati program koji:
//Ucitava stranicu https://cms.demo.katalon.com/
//Hvata  sve href atribute svih linkova iz navigacije
//Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//Koristan link za citanje status koda nekog url-a

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://cms.demo.katalon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

//        https://stackoverflow.com/questions/6467848/how-to-get-http-response-code-for-a-url-in-java/19303356#19303356
        List<WebElement> navigation = driver.findElements(By.xpath("//ul[contains(@class, ' nav-menu')]/li/a"));
        for (int i = 0; i < navigation.size(); i++) {
            String u = navigation.get(i).getAttribute("href");
            if(getHTTPResponseStatusCode(u)>=200 && getHTTPResponseStatusCode(u)<400){
                System.out.println("jeste");
            } else {
                System.out.println("nije");
            }
        }
        Thread.sleep(5000);
        driver.quit();
    }

    public static int getHTTPResponseStatusCode(String u) throws IOException {
        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
}

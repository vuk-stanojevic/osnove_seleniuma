package p2_2_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class UvodUTestNG {

    private WebDriver driver;

    private WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://www.google.com/");
    }

    @Test
    public void googleTitleTest() {
        //hard assert (tvrdi assert) - provera koja mora da bude tacna da bi mogli da se izvrsavaju ostali koraci
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void googleUrlTest() {
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");

        //Kad radimo Assert, uvek nam je potrebno objasnjenje za nasu gresku i to je obavezni treci parametar u metodi,
//        i to objasnjenje se stampa samo ako taj test padne, a ne ako prodje.
        int numberOfLinks = driver.findElements(By.tagName("a")).size();
        Assert.assertEquals(numberOfLinks, 40, "Number of links on homepage is not the same as expected");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();
    }


}

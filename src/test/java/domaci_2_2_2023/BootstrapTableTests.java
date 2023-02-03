package domaci_2_2_2023;

import com.sun.org.glassfish.gmbal.Description;
import helper.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {

//1.Zadatak
//Kreirati BootstrapTableTests klasu koja ima:
//Base url: https://s.bootsnipp.com
//Test #1: Edit Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Edit dugme prvog reda
//Sacekati da dijalog za Editovanje bude vidljiv
//Popuniti formu podacima.
//Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//Klik na Update dugme
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #2: Delete Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Delete dugme prvog reda
//Sacekati da dijalog za brisanje bude vidljiv
//Klik na Delete dugme iz dijaloga
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da je broj redova u tabeli za jedan manji
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #3: Take a Screenshot
//Koraci:
//Ucitati stranu  /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Kreirati screenshot stranice.
//Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png

    private WebDriver driver;

    private WebDriverWait wait;

    private String baseURL = "https://s.bootsnipp.com";

    private String firstName = "Vuk";
    private String lastName = "Stanojevic";
    private String middleName = "Jovan";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseURL);
    }

    @Test(priority = 1)
    @Description("TC1 - Verify that the input fields are displaying entered data")
    public void fieldsDisplayEnteredData() throws InterruptedException {
        driver.get(baseURL + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Page title is not the same.");
        driver.findElement(By.xpath("//tr[1]//button[@data-target='#edit']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("up"))));
//        alternativa:
//        Thread.sleep(3000);
//        Assert.assertTrue(driver.findElement(By.id("edit")).isDisplayed(), "Edit dialogue is not visible.");

//        https://www.tutorialspoint.com/what-does-webelement-clear-do-to-textboxes
        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("fn")).sendKeys(firstName);
        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("ln")).sendKeys(lastName);
        driver.findElement(By.id("mn")).clear();
        driver.findElement(By.id("mn")).sendKeys(middleName);
        driver.findElement(By.id("up")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("up"))));
        Assert.assertEquals(driver.findElement(By.id("f1")).getText(), firstName,
                "The displayed first name does not match the entered first name");
        Assert.assertEquals(driver.findElement(By.id("l1")).getText(), lastName,
                "The displayed last name does not match the entered last name");
        Assert.assertEquals(driver.findElement(By.id("m1")).getText(), middleName,
                "The displayed middle name does not match the entered middle name");
    }

    @Test(priority = 2)
    @Description("TC2 - Verify that the delete button deletes a row")
    public void deleteButtonDeletesARow() throws InterruptedException {
        driver.get(baseURL + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Page title is not the same.");
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
//        https://stackoverflow.com/a/27589656
        int count = 0;
        for(WebElement row: rows){
            if(row.isDisplayed()){
                count++;
            }
        }
        driver.findElement(By.xpath("//tr[1]//button[@data-target='#delete']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("del"))));
//        alternativa:
//        Thread.sleep(3000);
//        Assert.assertTrue(driver.findElement(By.id("delete")).isDisplayed(), "Delete dialogue is not visible.");

        driver.findElement(By.id("del")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("del"))));
        Assert.assertNotSame(count, count-1, "The number of rows has not decreased by 1");
    }

    @Test(priority = 3)
    @Description("TC3 - Verify the page title and take a screenshot")
    public void pageTitleAndScreenshot() throws InterruptedException, IOException {
        driver.get(baseURL + "/iframe/K5yrx");
        Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Page title is not the same.");
        //        https://www.browserstack.com/guide/take-screenshots-in-selenium
        new Helper().takeScreenshot(driver, "screenshots/slika.png");
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

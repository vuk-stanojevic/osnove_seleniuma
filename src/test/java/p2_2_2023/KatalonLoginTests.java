package p2_2_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonLoginTests {

//    1.Zadatak
//Kreirati klasu KatalonLoginTests za testove
//Base url: https://cms.demo.katalon.com
//Test #1: Visit login page from Nav bar
//Koraci:
//Ucitati home stranicu
//Kliknuti na My account link
//Verifikovati da je naslov stranice My account – Katalon Shop
//Verifikovati da se u url-u stranice javlja /my-account
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//    Test #2: Check input types
//Koraci:
//Ucitati /my-account stranicu
//Verifikovati da  polje za unos email-a za atribu type ima vrednost text
//Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
//Verifikovati da je Remember me checkbox decekiran. Koristan link kako naci informaciu da li je checkbox cekiran ili ne.
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//    Test #3: Display error when credentials are wrong
//Podaci:
//email: invalidemail@gmail.com
//password: invalid123
//Koraci:
//Ucitati /my-account stranicu
//Unesite email
//Unesite password
//Kliknite na login dugme
//Verifikovati da postoji element koji prikazuje gresku
//Verifikovati da je prikazana greska ERROR: Invalid email address
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//Verifikovati da smo idalje na login stranici posle greske, tako sto proveravamo da se url-u javlja /my-account

    public WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://cms.demo.katalon.com/");
    }

    @Test(priority = 1)
    @Description("TC 1 - Verify that login page can be visited from the navigation bar")
    public void visitLoginPageFromNavBar(){
        driver.findElement(By.xpath("//li/a[contains(@href, 'my-account')]")).click();
        Assert.assertEquals(driver.getTitle(),
                "My account – Katalon Shop", "Page title is not the same.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.demo.katalon.com/my-account/",
                "URL is not the same.");
    }

    @Test(priority = 2)
    @Description("TC 2 - Verify that login input fields have the correct types")
    public void checkingLoginInputFields(){
        //ne treba sa pocetne stranice sad, nego direktno sa driver.get()
//        driver.findElement(By.xpath("//li/a[contains(@href, 'my-account')]")).click();
        driver.get("https://cms.demo.katalon.com/my-account/");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='username']")).getAttribute("type"),
                "text", "The email input field's type is not 'text'.");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='password']")).getAttribute("type"),
                "password", "The password input field's type is not 'password'.");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='rememberme']")).getAttribute("type"),
                "checkbox", "The remember me field's type is not 'checkbox'");
//        https://artoftesting.com/check-if-a-checkbox-is-checked-in-selenium-webdriver-java#Verify_if_a_checkbox_is_checked_or_not
        Assert.assertFalse(driver.findElement(By.xpath("//input[@name='rememberme']")).isSelected(),
                "The checkbox is selected");
    }

    @Test(priority = 3)
    @Description("TC 3 - Verify that an error is displayed when login credentials are wrong")
    public void errorLoginWithWrongCredentials(){
        //ne treba sa pocetne stranice sad, nego direktno sa driver.get()
//        driver.findElement(By.xpath("//li/a[contains(@href, 'my-account')]")).click();
        driver.get("https://cms.demo.katalon.com/my-account/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("invalid123");
        driver.findElement(By.name("login")).click();
        Assert.assertTrue(driver.findElement(By.className("woocommerce-error")).isDisplayed(),
                "The error message is not displayed");
        //alternativa za error message je samo da se uradi waiter za nju. Prednost ovog nacina je sto se ceka na gresku,
//        ali mana to sto je greska "prljava", odnosno nemamo error message kao za assert nacin
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"))
                        .getText().contains("ERROR: Invalid email address"),
                "The error message does not contain the 'ERROR: Invalid email address' part");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Not on the 'my account' page");
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

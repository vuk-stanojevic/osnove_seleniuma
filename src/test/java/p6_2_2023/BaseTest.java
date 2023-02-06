package p6_2_2023;

import helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

//    milanov primer:
//    protected String baseUrl = "https://s.bootsnipp.com";

    //zadatak sa casa:
    protected String baseUrl = "https://cms.demo.katalon.com";

    protected NavPage navPage;

    protected ProductPage productPage;

    protected CartPage cartPage;

    protected TablePage tablePage;
    protected EditDialogPage editDialogPage;
    protected DeleteDialogPage deleteDialogPage;

//    milanov primer:
//    @BeforeClass
//    public void setup() {
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        tablePage = new TablePage(driver, wait);
//        editDialogPage = new EditDialogPage(driver, wait);
//        deleteDialogPage = new DeleteDialogPage(driver, wait);
//    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        tablePage = new TablePage(driver, wait);
        editDialogPage = new EditDialogPage(driver, wait);
        deleteDialogPage = new DeleteDialogPage(driver, wait);
        navPage = new NavPage(driver, wait);
        productPage = new ProductPage(driver, wait);
        cartPage = new CartPage(driver, wait);
    }


    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }


    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }
}

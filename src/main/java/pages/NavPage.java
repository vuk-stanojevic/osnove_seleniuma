package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{

    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getCartLink(){
        return driver.findElement(By.xpath("//div[@id='primary-menu']/ul/li[1]"));
    }

    public WebElement getCheckoutLink(){
        return driver.findElement(By.xpath("//div[@id='primary-menu']/ul/li[2]"));
    }

    public WebElement getMyAccountLink(){
        return driver.findElement(By.xpath("//div[@id='primary-menu']/ul/li[3]"));
    }

    public WebElement getSamplePageLink(){
        return driver.findElement(By.xpath("//div[@id='primary-menu']/ul/li[4]"));
    }

    public WebElement getShopLink(){
        return driver.findElement(By.xpath("//div[@id='primary-menu']/ul/li[5]"));
    }
}

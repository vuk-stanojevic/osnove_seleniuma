package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getDeleteButtonByRow(int row){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td[@class='product-remove']/a"));
    }

    public WebElement getCouponInput(){
        return driver.findElement(By.name("coupon_code"));
    }

    public WebElement getApplyCouponButton(){
        return driver.findElement(By.name("apply_coupon"));
    }

    public WebElement getUpdateCartButton(){
        return driver.findElement(By.name("update_cart"));
    }

    public List<WebElement> getItemTableRows(){
        return driver.findElements(By.xpath("//tbody/tr[contains(@class, 'cart_item')]"));
    }

    //po milanovoj sugestiji, dodat parametar i broj ocekivanih proizvoda u korpi, jer ne mora uvek 0 da se ceka
    public void waitForTheItemToBeRemovedFromCart(int expectedNumberOfRows){
        wait.until(ExpectedConditions.numberOfElementsToBe
                (By.xpath("//tbody/tr[contains(@class, 'cart_item')]"), expectedNumberOfRows));
    }
}

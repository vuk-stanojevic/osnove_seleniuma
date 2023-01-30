package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

    public boolean elementExists(WebDriver driver, By by) {
        boolean elementExists = true;
        try {
            WebElement div = driver.findElement(by);
        } catch (NoSuchElementException error) {
            elementExists = false;
        }
        return elementExists;
    }

    public boolean elementExistsByList(WebDriver driver, By by) {
        return driver.findElements(By.id("id-0")).size() > 0;
    }

}

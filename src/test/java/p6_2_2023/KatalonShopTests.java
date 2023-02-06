package p6_2_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KatalonShopTests extends BaseTest{

//    Zadatak
//Kreirati NavPage koja ima:
//cart link
//checkout link
//my account link
//sample page link
//shop link
//Kreirati ProductPage koja ima:
//quantity
//add to cart button
//poruka o dodavanju proizvoda u korpu
//	Kreirati CartPage
//hvata delete dugme za red po indeksu
//input za kupon
//dugme apply coupon
//update cart dugme
//hvata sve redove tabele
//
//
//	Kreirati KatalonShopTests klasu:
//	baseUrl: https://cms.demo.katalon.com
//	Test #1:  Adding product with quantity to the cart
//	Prioritet = 10
//	Koraci:
//Ucitati stranicu /product/flying-ninja/
//Unesite kolicinu 3
//Klik na Add to cart dugme
//Verifikovati da poruka sadrzi tekst “Flying Ninja”.
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//
//	Test #2:  Removing product from cart
//	Prioritet = 20
//	Koraci:
//Klik na Cart link iz navigacije
//Verifikovati da u url-u stoji /cart ruta
//Verifikovati da je broj proizvoda u korpi jednako 1
//Klik na remove dugme iz prvog reda
//Verifikovati da je broj proizvoda u korpi jedako 0

    @Test(priority = 10)
    @Description("TC1 - Verify that user can add product with quantity to the cart")
    public void addProductWithQuantityToCart(){
        driver.get(baseUrl + "/product/flying-ninja/");
        productPage.getQuantityInput().clear();
        productPage.getQuantityInput().sendKeys("3");
        productPage.getAddToCartButton().click();
        Assert.assertTrue(productPage.getAddToCartMessage().getText().contains("Flying Ninja"),
                "The message does not contain the 'Flying Ninja' part");
        navPage.getCartLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "The URL does not contain the '/cart' part");
        Assert.assertEquals(cartPage.getItemTableRows().size(), 1, "The cart does not contain 1 product");
    }

    @Test(priority = 20)
    @Description("TC2 - Verify that user can remove product from cart")
    public void removeProductFromCart(){
        navPage.getCartLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "The URL does not contain the '/cart' part");
        Assert.assertEquals(cartPage.getItemTableRows().size(), 1, "The cart does not contain 1 product");
        cartPage.getDeleteButtonByRow(1).click();
        cartPage.waitForTheItemToBeRemovedFromCart(0);
//        linija ispod nije ni potrebna jer to vec radi waiter iznad, a mora da se saceka jer je potrebno neko vreme
//        da se proizvod skloni iz korpe
//        Assert.assertEquals(cartPage.getItemTableRows().size(), 0, "The cart is not empty");
    }

}

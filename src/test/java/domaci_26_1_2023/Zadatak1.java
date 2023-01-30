package domaci_26_1_2023;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
// 1. Zadatak
//Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//Visit Paris
//Visit Prague
//Visit London
//Visit New York
//Visit Belgrade
//Maksimizirati prozor
//Ucitati stranicu https://example.cypress.io/todo
//Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//Nakon svakog unosa todo-a, unosi se enter
//Validira da li je novi todo dodat na stranici
//Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//Validirati da je na kraju programa broj todo-a na stranici 0.
//Cekanje od 5s
//Zatvorite pretrazivac

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        ArrayList<String> todosAdd = new ArrayList<>();
        todosAdd.add("Visit Paris");
        todosAdd.add("Visit Prague");
        todosAdd.add("Visit London");
        todosAdd.add("Visit New York");
        todosAdd.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        WebElement inputField = driver.findElement(By.className("new-todo"));
        for (int i = 0; i < todosAdd.size(); i++) {
            inputField.sendKeys(todosAdd.get(i));
            inputField.sendKeys(Keys.ENTER);
            if (driver.findElement(By.xpath("//ul[@class='todo-list']/li[last()]")).
                    getText().equals(todosAdd.get(i))){
                System.out.println("Dodat je nov to do");
            }
        }
//      https://www.scientecheasy.com/2020/01/move-element-in-selenium.html/
//      https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element
        Actions actions = new Actions(driver);
        List<WebElement> todosAll = driver.findElements(By.className("toggle"));
        for (int i = 0; i < todosAll.size(); i++) {
            actions.moveToElement(todosAll.get(i)).perform();
            driver.findElement(By.className("destroy")).click();
        }

        List<WebElement> todosNone = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        if(todosNone.size()==0){
            System.out.println("Broj to do-ova na stranici je 0");
        }

        Thread.sleep(5000);
        driver.quit();

    }
}

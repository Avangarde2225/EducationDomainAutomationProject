package HerokuAppAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class clickingOnDeleteButton {
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Delete" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

    @BeforeMethod
    public void clickAndValidateButtons() {
        WebElement btn = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        int num = 50;
        for (int i = 0; i < num; i++) {
            btn.click();
        }
    }

    @Test
    public void deleteAndQuit() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int sizeBeforeDeleting = elements.size();

        List<WebElement> buttonsToDelete = driver.findElements( By.cssSelector( "[onclick='deleteElement()']" ) );
        int counter = 0;
        int number = 50;
        for(WebElement webElement : buttonsToDelete) {
            counter++;
            if(counter > number) {
                break;
            }
            webElement.click();
        }


        List<WebElement> elementsAfter = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeAfterDeleting = elementsAfter.size();

        Assert.assertEquals(sizeAfterDeleting, (sizeBeforeDeleting - number));

    }
}



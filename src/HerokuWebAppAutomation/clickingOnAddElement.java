package HerokuWebAppAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class clickingOnAddElement {
    // http://the-internet.herokuapp.com/add_remove_elements/
    // write a function that takes a number, and clicks the "Add Element" button
    // given number of times, and then validate that given number of
    // "Delete" buttons is displayed
    private WebDriver driver;

    @BeforeClass
    public  void main() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

    @Parameters({"numberOfTimeToClick"})
    @Test
    public void clickToValidate (String numberOfTimeToClick){

       int num = Integer.parseInt(numberOfTimeToClick);

        WebElement element = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 0; i < num; i++) {
            element.click();
        }

        List<WebElement> list = driver.findElements(By.xpath("//button[@class='added-manually']"));

        Assert.assertEquals(list.size(), num);

    }


}

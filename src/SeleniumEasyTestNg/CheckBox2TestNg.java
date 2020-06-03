package SeleniumEasyTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBox2TestNg {
    // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // Check the Multiple Checkbox and check the button message
    // When you check all the checkboxes, button message will change to 'Uncheck All'
    // When you uncheck at least one checkbox, button message will change to 'Check All'

    WebDriver driver;

    @AfterClass
    public void quit(){
        driver.quit();
    }
    @BeforeClass
    public void prepareWebDriver(){
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/basic-checkbox-demo.html" );
        driver.manage().window().maximize();
    }

    @Test
    public void checkedTest(){
        driver.findElement(By.xpath("//input[@type='button']")).click();
        String actualText = driver.findElement(By.xpath("//input[@value='Uncheck All']")).getAttribute("Value");
        Assert.assertEquals(actualText,"Uncheck All");
    }
    @Test
    public void uncheckedTest(){
        driver.findElement(By.xpath("//input[@type='button']")).click();
        String actualText = driver.findElement(By.xpath("//input[@value='Check All']")).getAttribute("Value");
        Assert.assertEquals(actualText,"Check All");

    }

}

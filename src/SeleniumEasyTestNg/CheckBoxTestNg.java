package SeleniumEasyTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CheckBoxTestNg {
    // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // Check the Single Checkbox and check the message bellow it

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
    }





}

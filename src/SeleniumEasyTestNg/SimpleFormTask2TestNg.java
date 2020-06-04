package SeleniumEasyTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SimpleFormTask2TestNg {
    // https://www.seleniumeasy.com/test/basic-first-form-demo.html
    // Fill in Two Input Fields with numbers, press the button and check result

    private WebDriver driver;

    @AfterClass
    public void quit(){
        driver.quit();
    }
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#at-cv-lightbox")));

        driver.findElement(By.cssSelector("div#at-cv-lightbox-button-holder> a:nth-child(2)")).click();
    }

        @Test
        public void test(){

        Integer number1 = 100;
        Integer number2 = 222;

        driver.findElement( By.id( "sum1" ) ).sendKeys( number1.toString() );

        driver.findElement( By.id( "sum2" ) ).sendKeys( number2.toString() );

        driver.findElement(By.cssSelector("#gettotal > button")).click();


    String text = driver.findElement( By.id( "displayvalue" ) ).getText();

    Assert.assertEquals(text, String.valueOf(number1+number2));
    }
}

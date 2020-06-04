package SeleniumEasyTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingAlertMessage {
    // https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html
    // click on the "Normal success message" button then validate
    // that message is equal "I'm a normal success message. To close use the appropriate button."
    // then click on X button on the message
    // validate the the message is invisible or not present
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
        driver.manage().window().maximize();
    }
        @AfterClass
        public void quit(){
        driver.quit();}

        @Test
        public void clickAndConfirm(){

        driver.findElement( By.id( "normal-btn-success" ) ).click();
        WebElement message = driver.findElement( By.cssSelector( ".alert-normal-success" ) );
        WebElement button = driver.findElement( By.cssSelector( ".alert-normal-success > button" ) );
        String text = message.getText().replace( button.getText(), "" ).trim();
        String test = "I'm a normal success message. To close use the appropriate button.";
        Assert.assertEquals(text, test);
    }

    @Test
    public void hidingTheMessage(){
        driver.findElement( By.id( "normal-btn-success" ) ).click();
        driver.findElement( By.cssSelector( ".alert-normal-success > button" )).click();
        WebElement message = driver.findElement( By.cssSelector( ".alert-normal-success" ) );

        Assert.assertFalse(message.isDisplayed());

    }
}

package SeleniumEasyTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class SimpleFormTask1TestNG {
    // https://www.seleniumeasy.com/test/basic-first-form-demo.html
    // Fill in Single Input Field with text, press the button and check result

    private WebDriver driver;

    @AfterClass
    public void quit(){
        driver.quit();
    }


    @BeforeClass
    public void setUp() {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/basic-first-form-demo.html" );
        driver.manage().window().maximize();



        WebElement message = driver.findElement( By.id( "user-message" ) );
        String myMessage = "Test string!";
        message.sendKeys( myMessage );

        List<WebElement> buttons = driver.findElements( By.tagName( "button" ) );
        for(WebElement button: buttons){
//            System.out.println(button.getText());
            if(button.getText().equals( "Show Message" )){
                button.click();
            }
        }

        WebElement display = driver.findElement( By.id( "display" ) );
        String text = display.getText();

        if(text.equals( myMessage )){
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }

        driver.quit();
    }
}

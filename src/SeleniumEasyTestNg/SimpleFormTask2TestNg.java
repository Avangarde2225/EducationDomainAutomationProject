package SeleniumEasyTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/basic-first-form-demo.html" );
        driver.manage().window().maximize();


        Integer number1 = 100;
        Integer number2 = 222;

        WebElement sum1 = driver.findElement( By.id( "sum1" ) );
        sum1.sendKeys( number1.toString() );

        WebElement sum2 = driver.findElement( By.id( "sum2" ) );
        sum2.sendKeys( number2.toString() );

        List<WebElement> buttons = driver.findElements( By.tagName( "button" ) );
        for(WebElement button : buttons) {
//            System.out.println(button.getText());
            if(button.getText().equals( "Get Total" )) {
                button.click();
            }
        }

        WebElement display = driver.findElement( By.id( "displayvalue" ) );
        String text = display.getText();

        if(text.equals( String.valueOf( number1 + number2 ) )) {
            System.out.println( "Success!" );
        } else {
            System.out.println( "Failure!" );
        }

        driver.quit();
    }
}

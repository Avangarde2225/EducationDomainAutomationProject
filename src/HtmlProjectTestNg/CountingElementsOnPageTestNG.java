package HtmlProjectTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CountingElementsOnPageTestNG {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///D:/Project/seleniumWorking/src/day3/resources/form.html");
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

    @Test(dataProvider = "tagNumberProvider")
    public void printNumberOfElementsOnAPage(String tagName, int numberOfElements) {

        List<WebElement> elements = driver.findElements(By.tagName(tagName));
        Assert.assertEquals(elements.size(), numberOfElements);

    }

    @DataProvider
    public Object[][] tagNumberProvider() {
       return new Object[][] {
                {"h1", 1},
                {"h2, 1"},
                {"h3", 1},
                {"p", 6},
                {"input", 7},
                {"option", 5},
                {"br", 6},
                {"select", 1},
                {"form", 1}
        };
    }
}



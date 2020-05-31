package FunctionalityChecks;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchingForElementsandPrintingThem {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://basqar.techno.study/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("div.cc-compliance > a")).click();

        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("nigeria_tenant_admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("TnvLOl54WxR75vylop2A");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //click on Entrance Exams > Setup > Entrance Exams
        driver.findElement(By.xpath("//span[contains(text(),'Entrance Exams')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Entrance Exams')]/../..//span[contains(text(),'Setup')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Setup')]/../..//span[contains(text(),'Entrance Exams')]")).click();

        //searhing for a particular grade

        driver.findElement(By.xpath("//input[@id='mat-input-4']")).sendKeys("1");
        driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-accent']")).click(); //click on search button

        //printing the search results
        List<WebElement> searchResults = driver.findElements(By.cssSelector("tbody>tr>td[class='mat-cell cdk-cell cdk-column-name mat-column-name ng-star-inserted']"));

        for (int i = 0; i <searchResults.size() ; i++) {
            List<WebElement> searchResult = driver.findElements(By.cssSelector("tbody>tr>td[class='mat-cell cdk-cell cdk-column-name mat-column-name ng-star-inserted']"));
            System.out.println(searchResult.get(i).getText());
        }

            driver.quit();
    }
}

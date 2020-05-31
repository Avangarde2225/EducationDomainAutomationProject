package FunctionalityChecks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EntranceExamAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://basqar.techno.study/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("nigeria_tenant_admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("TnvLOl54WxR75vylop2A");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //click on Entrance Exams > Setup > Entrance Exams
        driver.findElement(By.xpath("//span[contains(text(),'Entrance Exams')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Entrance Exams')]/../..//span[contains(text(),'Setup')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Setup')]/../..//span[contains(text(),'Entrance Exams')]")).click();


    }
}

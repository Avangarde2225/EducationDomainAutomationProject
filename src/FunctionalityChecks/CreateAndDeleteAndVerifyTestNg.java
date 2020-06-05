package FunctionalityChecks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateAndDeleteAndVerifyTestNg {
    private WebDriver driver;

    @Parameters({"username","password"})
    @BeforeClass
    public void setUp(String username, String password) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suler\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://basqar.techno.study/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("div.cc-compliance > a")).click();
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

    @Test
    public void examCreation() {
        //Exam Creation and Verification

        //click on Entrance Exams > Setup > Entrance Exams
        driver.findElement(By.xpath("//span[contains(text(),'Entrance Exams')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Entrance Exams')]/../..//span[contains(text(),'Setup')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Setup')]/../..//span[contains(text(),'Entrance Exams')]")).click();

        //Create exam fields
        driver.findElement(By.xpath("//ms-add-button//div//button[@class='mat-focus-indicator mat-button mat-icon-button mat-button-base ng-star-inserted']")).click();

        WebElement entranceExamName = driver.findElement(By.xpath("//div//ms-text-field//input[@id='ms-text-field-0']"));
        String entranceExam = "67th Grade";
        entranceExamName.sendKeys(entranceExam);

        driver.findElement(By.xpath("//span[text()='Academic Period']")).click(); //makes the section visible
        driver.findElement(By.xpath("//span[text()=' 2019 - 2020 time ']")).click();  // selects the dropdown

        driver.findElement(By.xpath("//span[text()='Grade Level']")).click(); //clicks on the grade dropdown
        driver.findElement(By.xpath("//div//mat-option//span[text()=' 67th Grade ']")).click();

        driver.findElement(By.xpath("//button[@class='mat-focus-indicator save-button mat-accent mat-button mat-raised-button mat-button-base ng-star-inserted']")).click();  //save button


        //Verify Successfully created message
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-tns-c94-75")));

    }
    //Exam Deletion and Verification

    @Test
    public void examDeletion() {
        driver.findElement(By.cssSelector("toolbar div:nth-child(3) >button")).click();

        driver.findElement(By.cssSelector("tbody tr:first-child ms-delete-button")).click(); //click on delete button
        driver.findElement(By.cssSelector("mat-dialog-container button[type=\"submit\"]")).click(); // click on yes

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-tns-c94-135")));


    }
}

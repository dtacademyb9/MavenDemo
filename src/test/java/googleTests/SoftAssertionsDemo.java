package googleTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class SoftAssertionsDemo {

    WebDriver driver;



    @BeforeClass (alwaysRun = true)
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }



    @BeforeMethod  (alwaysRun = true)// configuration methods
    public void setupMethod(){
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void googleSearchTest1() throws InterruptedException {

        driver.findElement(By.name("q")).sendKeys("chicken", Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='yuRUbf']//h3"));


        SoftAssert softAssert = new SoftAssert();
        int count = 1;
        for (WebElement result : results) {


            System.out.println("Iteration no " + count + ": " + result.getText());
            softAssert.assertTrue(result.getText().toLowerCase().contains("chicken"));

            count++;
        }
        softAssert.assertAll();

        // These questions mean the same

        // What is the difference between Hard  vs Soft assertions?
        //What is the difference between assert vs verify?

    }






}

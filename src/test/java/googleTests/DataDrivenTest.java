package googleTests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class DataDrivenTest {

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

    @Test (dataProvider = "getData")
    public void googleSearchTest(String searchTerm) {

        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(searchTerm));

    }


    @DataProvider
    public Object[][] getData(){

        return new Object[][] {
                {"chicken"},
                {"はい"},
                {"아니오"},
                {"aşk"},
                {"नहीं चाहिये"}
        };
    }

    @DataProvider
    public Object[][] getData2(){


            return new Object[][] {
                    {new Faker().animal().name()},
                    {new Faker().animal().name()},
                    {new Faker().animal().name()},
                    {new Faker().animal().name()},
                    {new Faker().animal().name()}
            };

    }









}

package googleTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class GoogleSearchTests2 {

    WebDriver driver;


    @BeforeGroups (groups = {"smoke"})
    public void setupGroups(){
        System.out.println("Smoke tests are configured");
    }

    @AfterGroups (groups = {"smoke"})
    public void tearDownGroups(){
        System.out.println("Smoke tests tear down is finished");
    }

    @BeforeClass (alwaysRun = true)
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass (alwaysRun = true)
    public void tearDownClass(){
        System.out.println("Actions that are done after everything is done within the class");
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

    @Test (groups = "smoke")
    public void googleSearchTest1() throws InterruptedException {

        driver.findElement(By.name("q")).sendKeys("chicken", Keys.ENTER);
        Thread.sleep(2000);
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='yuRUbf']//h3"));

        for (WebElement result : results) {

            if(!result.getText().isEmpty()){
                Assert.assertTrue(result.getText().toLowerCase().contains("chicken"));
            }

        }

    }

    @Test (groups = {"title", "smoke"})
    public void googleSearchTest2(){

        driver.findElement(By.name("q")).sendKeys("chicken", Keys.ENTER);
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='yuRUbf']//h3"));
        results.get(0).click();

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("chicken"));

    }

    @Test (groups = {"title"})
    public void googleSearchTest3(){

        driver.findElement(By.name("q")).sendKeys("chicken", Keys.ENTER);
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='yuRUbf']//h3"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",results.get(results.size()-1)) ;

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("chicken"));

    }








}

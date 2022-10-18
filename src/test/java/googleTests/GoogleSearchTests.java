package googleTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleSearchTests {

    WebDriver driver;

    @BeforeClass  (alwaysRun = true)
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass (alwaysRun = true)
    public void tearDownClass(){
        System.out.println("Actions that are done after everything is done within the class");
    }

    @BeforeMethod (alwaysRun = true) // alwaysRun should be set to true in order for group tests to run correctly
    public void setupMethod(){
        driver =  new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(){
        driver.quit();
    }

    @Test ( priority = 2, groups = {"title", "smoke"})
    public void googleSearchTest(){

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Iphone"));

    }

    @Test  (priority = 4)
    public void googleSearchTest4(){

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("Iphone"));

    }


    @Test (priority = 5, groups = {"smoke"})
    public void googleSearchTest5(){

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("Iphone"));

    }

    @Test (priority = 1)
    public void googleSearchTestFailing(){

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("idsphone"));

    }

    @Test (priority = 3)
    public void googleSearchTest3(){

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("Iphone"));

    }







}

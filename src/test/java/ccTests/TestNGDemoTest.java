package ccTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemoTest {

    WebDriver driver;

    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("Actions that are done after everything is done within the class");
    }

    @BeforeMethod  // configuration methods
    public void setupMethod(){
               driver =  new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test ( priority = 2)
    public void googleSearchTest(){

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Iphone"));

    }

    @Test  (priority = 4)
    public void googleSearchTest4(){

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("Iphone"));

    }


    @Test (priority = 5)
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

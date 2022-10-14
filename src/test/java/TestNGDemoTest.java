import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemoTest {

    WebDriver driver;

    @BeforeMethod  // configuration methods
    public void setupMethod(){
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void googleSearchTest(){

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Iphone"));

    }

    @Test
    public void googleSearchTestFailing(){

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("idsphone"));

    }

    @Test
    public void googleSearchTest3(){

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("Iphone"));

    }



}

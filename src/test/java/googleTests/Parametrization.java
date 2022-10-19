package googleTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Parametrization {

    WebDriver driver;





    @Test
    @Parameters ({"link", "searchTerm", "age"})
    public void googleSearchTest2(String url, String term, int age){

        System.out.println(age);
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.name("q")).sendKeys(term, Keys.ENTER);
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='yuRUbf']//h3"));
        results.get(0).click();

        Assert.assertTrue(driver.getTitle().toLowerCase().contains(term));

        driver.quit();

    }

    @Test
    @Parameters ("browserType")
    public void googleSearchTestCrossBrowser(String browser){

        switch (browser){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver =  new ChromeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver =  new FirefoxDriver();
                break;

            case "edge" :
                WebDriverManager.edgedriver().setup();
                driver =  new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid driver");
        }




        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("apple", Keys.ENTER);
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='yuRUbf']//h3"));
        results.get(0).click();

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("apple"));

        driver.quit();

    }










}

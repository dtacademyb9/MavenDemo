package googleTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class TimeoutTest {


    WebDriver driver;



    @BeforeMethod(alwaysRun = true)
    public void setupClass(){
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }



    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }



    @Test (timeOut = 10000)
    public void verifySearchResults(){
        driver.findElement(By.name("q")).sendKeys("chicken", Keys.ENTER);

        List<WebElement> results = driver.findElements(By.xpath("//div[@class='yuRUbf']//h3"));

        for (WebElement result : results) {

            while(true){
                System.out.println("Blavla");
            }
//            if(!result.getText().isEmpty()){
//                Assert.assertTrue(result.getText().toLowerCase().contains("chicken"));
//            }

        }
    }

    @Test
    public void verifySearchResults2(){
        driver.findElement(By.name("q")).sendKeys("chicken", Keys.ENTER);

        List<WebElement> results = driver.findElements(By.xpath("//div[@class='yuRUbf']//h3"));

        for (WebElement result : results) {


            if (!result.getText().isEmpty()) {
                Assert.assertTrue(result.getText().toLowerCase().contains("chicken"));


            }

        }
    }
}

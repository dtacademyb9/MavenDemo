import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Demo {


    public static void main(String[] args) {


        System.out.println("Hello Maven!");

        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();

//
//        WebDriverManager.edgedriver().setup();
//        WebDriver driver =  new EdgeDriver();


        driver.get("https://www.google.com/");


        // Search for a term

        driver.findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);
        // Verify that search results page title has that term

        Assert.assertTrue(driver.getTitle().contains("Iphone"));

        driver.quit();




    }


}

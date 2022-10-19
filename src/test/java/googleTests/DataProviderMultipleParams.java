package googleTests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DataProviderMultipleParams {

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
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


    }

    @AfterMethod (alwaysRun = true)
    public void tearDownMethod(){
        driver.quit();
    }

    @Test (dataProvider = "getData")
    public void googleSearchTest(String name, String address, String city,String state, int zip, long cardNumber ) throws InterruptedException {

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,"test",Keys.ENTER);
        driver.findElement(By.xpath("//a[contains(text(),'Order')]")).click();
        String randomQt = String.valueOf((int) (1+Math.random()*99));
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE,randomQt);
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        Thread.sleep(1000);


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(
                name,Keys.TAB,
                address,Keys.TAB,
                city,Keys.TAB,
                state,Keys.TAB,
                zip+"",Keys.TAB);

        int cardType = (int)(Math.random()*3);


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_"+cardType)).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNumber+"",Keys.TAB,"10/25");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        Assert.assertTrue(driver.getPageSource().contains("New order has been successfully added."));

    }


    @DataProvider
    public Object[][] getData(){

        return new Object[][] {
                {"Glynda Fragino","621 Saint Paul Court","Chattanooga","Tennessee",37410,5108752137261547L},
                {"Sebastien Heisman","818 Bultman Pass","Jeffersonville","Indiana",47134,5048374836422503L},
                {"Donica Josefovic","78103 Porter Drive","Austin","Texas",78721,5048371352972440L},
                {"Murial Frew","0127 Tony Court","Philadelphia","Pennsylvania",19093,5048375688966687L},
                {"Selene Rysdal","0058 Coleman Court","Vienna","Virginia",22184,5048375701405713L}

        };
    }











}

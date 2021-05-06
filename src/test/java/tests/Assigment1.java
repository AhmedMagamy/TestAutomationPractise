package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assigment1
{
    public WebDriver driver;

    //setup method that calls the browser driver and open base url
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

    }

   @Test
   public void test(){
       WebElement searchTextField = driver.findElement(By.name("q"));
       searchTextField.sendKeys("test");
       searchTextField.sendKeys(Keys.ENTER);
   // driver.findElement(By.name("q")).sendKeys("test");
   // driver.findElement(By.name("btnK")).click();
    driver.findElement(By.xpath(" //div[@data-hveid='CAIQAA']//ancestor::h3")).click();
   }

    //responsible for closing
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        //driver.quit();
    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assignment2 {

    public WebDriver driver;

    //setup method that calls the browser driver and open base url
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        //to handle no such element exceptions
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
        driver.manage().window().maximize();

    }
    /*
    @Test
    public void test(){

        String taskToFind="Landing Page";
        List<WebElement> tasksColumnElements = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr/td[2]"));
        List<WebElement> assignColumnElements = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr/td[3]"));
        List<WebElement> statusColumnElements = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr/td[4]"));
        int indexOfSearch=0;
        for(int i = 0 ; i<tasksColumnElements.size();i++)
        {
            if(tasksColumnElements.get(i).getText().equalsIgnoreCase(taskToFind)){
                indexOfSearch=i;
                break;
            }
        }
        String assigne = assignColumnElements.get(indexOfSearch).getText();
        String status = statusColumnElements.get(indexOfSearch).getText();
        System.out.println("Task="+taskToFind + ", Assignee ="+assigne + ", status ="+status);
    }

    */

    @Test
    public void test(){

        String taskToFind="Landing Page";
        List<WebElement> tasksColumnElements = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr/td[2]"));

        int indexOfSearch=0;
        for(int i = 0 ; i<tasksColumnElements.size();i++)
        {
            if(tasksColumnElements.get(i).getText().equalsIgnoreCase(taskToFind)){
                indexOfSearch=i;
                break;
            }
        }

        indexOfSearch++;

        String assigne = driver.findElement(By.xpath("(//table[@class='table table-hover']/tbody/tr/td[3])["+indexOfSearch+"]")).getText();
        String status = driver.findElement(By.xpath("(//table[@class='table table-hover']/tbody/tr/td[4])["+indexOfSearch+"]")).getText();

        System.out.println("Task="+taskToFind + ", Assignee ="+assigne + ", status ="+status);
    }

    //responsible for closing
    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}

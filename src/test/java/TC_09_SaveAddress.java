import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_09_SaveAddress extends ExtendReportMethod{
    @Test
    public void updateaddress()throws IOException
    {
        test = reports.createTest (" updateaddress");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        Login loginPage = new Login (driver);
        loginPage.Login ("9074882364", "12345");
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        WebElement we = driver.findElement(By.xpath("//div[contains(text(), 'Jain')]"));
        action.moveToElement(we).build().perform();
        driver.findElement(By.xpath("//div[contains(text(), 'My Profile')]")).click ();
        driver.findElement(By.xpath("//div[contains(text(), 'Manage Addresses')]")).click ();
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[contains(text(), 'ADD A NEW ADDRESS')]")).click ();
      driver.findElement (By.name ("name")).sendKeys ("Jain");
        driver.findElement (By.name ("phone")).sendKeys ("9061173355");
        driver.findElement (By.name ("pincode")).sendKeys ("691307");
        driver.findElement (By.name ("addressLine2")).sendKeys ("punalur");
        driver.findElement (By.name ("addressLine1")).sendKeys ("Pettayil veedu");
        driver.findElement (By.xpath ("//div[contains(text(), 'State')]"));
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        WebElement signUp = driver.findElement(By.xpath("//button[contains(@class,'_2AkmmA EqjTfe eLvSG3 _7UHT_c')]"));
        signUp.click();
        test.addScreenCaptureFromPath (Driver.takeScreenshot ());
        Driver.closeBrowser ();



    }


}

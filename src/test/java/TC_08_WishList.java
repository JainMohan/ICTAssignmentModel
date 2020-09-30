import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_08_WishList extends ExtendReportMethod{
    @Test
    public void Addtowishlist()throws IOException
    {
        test = reports.createTest (" Addtowishlist");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        Login loginPage = new Login (driver);
        loginPage.Login ("9074882364", "12345");
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.findElement (By.name ("q")).sendKeys ("flower" + Keys.ENTER);
        driver.findElement (By.xpath ("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/a[1]/div[2]/div")).click ();
        driver.findElement (By.xpath ("//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")).click ();
        Actions action = new Actions(driver);
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        WebElement we = driver.findElement(By.xpath("//div[contains(text(), 'Jain')]"));
        action.moveToElement(we).build().perform();
        driver.findElement (By.xpath ("//div[contains(text(), 'Wishlist')]")).click ();
        test.addScreenCaptureFromPath (Driver.takeScreenshot ());
        Driver.closeBrowser ();
    }
}

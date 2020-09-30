import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_10_OfferZone extends ExtendReportMethod{
@Test
    public void offerzonedisplay()throws IOException
    {
        test = reports.createTest ("offerzonedisplay");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        driver.manage ().timeouts ().implicitlyWait (10,TimeUnit.SECONDS);
        driver.findElement (By.className ("_29YdH8")).click ();
        driver.findElement (By.xpath ("//*[@id='container']/div/div[2]/div/div/a[2]")).click ();
        WebDriverWait wait1 = new WebDriverWait (driver, 40);
        wait1.until (ExpectedConditions.presenceOfElementLocated (By.xpath("//*[@id='container']/div/div[2]/div/div/a[2]")));
       test.addScreenCaptureFromPath (Driver.takeScreenshot ());
        Driver.closeBrowser ();



    }


}

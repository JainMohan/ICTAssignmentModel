import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class TC_01_validLogin extends ExtendReportMethod
{

    @Test(priority = 0)//Verify hello Login

    public void verifyhellosign()throws InterruptedException,IOException
    {
        test = reports.createTest ("verifyhellosign");
      WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Reporter.log ("Flipkart is open");
        String Actual = driver.getTitle();
        String Expected = "Hello Sign";
        Assert.assertEquals(Expected, Actual);
        Reporter.log ("Verifying the page with page title");
        try {
            Assert.assertEquals(Expected, Actual);
            Reporter.log ("Flipkart title matches the expected titile");
        }
        catch (Error e)
        {
            System.out.println (e.getCause ());
            Reporter.log ("Flipkart title doesn't matches the expected titile");
        }
        Driver.closeBrowser ();
    }

    @Test(priority = 1)//Valid credentials checking
    public void LoginTest() throws IOException
    {
        test = reports.createTest ("LoginTest");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        Login loginPage = new Login (driver);
        loginPage.Login ("9074882364", "12345");
        WebDriverWait wait1 = new WebDriverWait (driver, 40);
        wait1.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")));
        test.addScreenCaptureFromPath (Driver.takeScreenshot ());


    }

}

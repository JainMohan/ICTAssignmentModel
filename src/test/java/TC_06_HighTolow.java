import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_06_HighTolow  extends ExtendReportMethod {

    @Test
    public void mobilenameverify() throws IOException
    {
        test = reports.createTest ("mobilenameverify");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        driver.findElement (By.className ("_29YdH8")).click ();
        driver.findElement (By.name ("q")).sendKeys ("mobile" + Keys.ENTER);
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.findElement (By.xpath ("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[4]")).click ();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        String ActualMobilename=  wait1.until (ExpectedConditions.presenceOfElementLocated(By.xpath ("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]"))).getText ();
        String ExpectedMobilename="Motorola Razr (Black, 128 GB)";
        Assert.assertEquals (ExpectedMobilename,ActualMobilename);
        test.addScreenCaptureFromPath (Driver.takeScreenshot ());
        Reporter.log ("Verifying the page with mobile");
        try {
            Assert.assertEquals(ExpectedMobilename, ActualMobilename);
            Reporter.log ("Flipkart title matches the expected mobile");
        }
        catch (Error e)
        {
            System.out.println (e.getCause ());
            Reporter.log ("Flipkart title doesn't matches the expected mobile");
        }

        Driver.closeBrowser ();
    }

}

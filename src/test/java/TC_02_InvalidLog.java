import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_02_InvalidLog extends ExtendReportMethod
{
    @Test
    public void invalidLogin() throws IOException {

        test = reports.createTest ("invalidLogin");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        Login loginPage = new Login (driver);
        loginPage.Login ("9074882364", "12347");
        String ExpectedRes = "Your username or password is incorrect";
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        String ActualRes= wait1.until(ExpectedConditions.presenceOfElementLocated (By.xpath ("//span[text()='Your username or password is incorrect']"))).getText ();
        Assert.assertEquals(ExpectedRes,ActualRes);
        test.addScreenCaptureFromPath (Driver.takeScreenshot ());
        Driver.closeBrowser ();
    }

}




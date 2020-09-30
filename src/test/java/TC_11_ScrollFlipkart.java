import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_11_ScrollFlipkart extends ExtendReportMethod {

    @Test
    public void flipAddressScroll() throws IOException {
        test = reports.createTest (" flipAddressScroll");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        driver.findElement (By.className ("_29YdH8")).click ();
        JavascriptExecutor jse6 = (JavascriptExecutor) driver;
        jse6.executeScript ("window.scrollBy(0,document.body.scrollHeight)");

        String ExpectedAddress="Flipkart Internet Private Limited,\n" +
                "Buildings Alyssa, Begonia &\n" +
                "Clove Embassy Tech Village,\n" +
                "Outer Ring Road, Devarabeesanahalli Village,\n" +
                "Bengaluru, 560103,\n" +
                "Karnataka, India\n" +
                "CIN : U51109KA2012PTC066107\n" +
                "Telephone: 1800 208 9898";
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        String ActualAddress=  wait1.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@id='container']/div/footer/div/div[3]/div[1]/div[6]/div/div[2]"))).getText ();
        test.addScreenCaptureFromPath (Driver.takeScreenshot ());
        Assert.assertEquals (ExpectedAddress,ActualAddress);
        Driver.closeBrowser ();


    }
}





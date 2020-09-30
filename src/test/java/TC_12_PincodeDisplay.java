import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TC_12_PincodeDisplay extends ExtendReportMethod {
@Test
    public void PincodeCheck()throws IOException
    {
        test = reports.createTest ("PincodeCheck");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.findElement (By.className ("_29YdH8")).click ();
        driver.findElement (By.name ("q")).sendKeys ("flower" + Keys.ENTER);
        driver.findElement (By.xpath ("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]")).click ();
        //driver.findElement (By.xpath ("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]")).click ();
        driver.manage ().window ().maximize ();
        Set<String> ids = driver.getWindowHandles ();
        Iterator<String> it = ids.iterator ();
        String parentId = it.next ();
        String childId = it.next ();
        driver.switchTo ().window (childId);
        driver.findElement (By.id ("pincodeInputId")).sendKeys ("691307" +Keys.ENTER);
        test.addScreenCaptureFromPath (Driver.takeScreenshot ());
        Driver.closeBrowser ();
    }
}

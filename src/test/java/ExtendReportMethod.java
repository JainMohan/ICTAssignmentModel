import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtendReportMethod {
    public static ExtentReports reports;
    public static ExtentSparkReporter extentSparkReporter;//html
    public static ExtentTest test;

    @BeforeSuite
    public void setup() {
        String path = System.getProperty ("user.dir");
        reports = new ExtentReports ();
        extentSparkReporter = new ExtentSparkReporter (path + "\\report\\report.html");
        reports.attachReporter (extentSparkReporter);
    }


    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus () == ITestResult.FAILURE) {
            test.log (Status.FAIL, MarkupHelper.createLabel (result.getName () + " Test case FAILED due to below issues:", ExtentColor.AMBER.RED));
            test.fail (result.getThrowable ());
        } else if (result.getStatus () == ITestResult.SUCCESS) {
            test.log (Status.PASS, MarkupHelper.createLabel (result.getName () + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            test.log (Status.SKIP, MarkupHelper.createLabel (result.getName () + " Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip (result.getThrowable ());
        }
    }

    @AfterSuite
    public void tearDown() {
        reports.flush ();
    }
}













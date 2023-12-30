package api.ObjectRepo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportForAPI implements ITestListener
{

	 public static ExtentSparkReporter spark;
	    public static ExtentReports extent;
	    public static ExtentTest test;
	    public static WebDriver driver;

	    String repname;


	    public void onTestStart(ITestResult result)
	    {
	        test=extent.createTest(result.getName());
	        test.log(Status.INFO, result.getName()+" Method Started");

	    }

	    public void onTestSuccess(ITestResult result)
	    {
	        test=extent.createTest(result.getName());
	        test.pass(MarkupHelper.createLabel(result.getName()+" case has PASSED", ExtentColor.GREEN));

	    }

	    public void onTestFailure(ITestResult result)
	    {
	        test=extent.createTest(result.getName());
	        test.fail(MarkupHelper.createLabel(result.getName()+" case has FAILED because of following reasons: ", ExtentColor.RED));
	        test.fail(result.getThrowable());

	        String failedTestCase = result.getMethod().getMethodName();
	        String currentDate = new Date().toString().replace(":", "_").replace(" ", "_");




	    }
	    public void onTestSkipped(ITestResult result) {
	        test=extent.createTest(result.getName());
	        test.skip(MarkupHelper.createLabel(result.getName()+" case has SKIPPED because of following reasons: ", ExtentColor.PINK));
	        test.skip(result.getThrowable());
	    }

	    public void onStart(ITestContext context)
	    {
	        Random rn= new Random();
	        int rand=rn.nextInt();
	        String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        repname="Test-Report_"+rand+timeStamp;
	    spark = new ExtentSparkReporter(".\\reports\\"+repname);
	        //Customising report view
	        spark.config().setDocumentTitle("Rest Assure Project");
	        spark.config().setReportName("Extent Reports 5");
	        spark.config().setTheme(Theme.DARK);
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	        //setting system info
	        extent.setSystemInfo("Author", "Mukesh");
	        extent.setSystemInfo("OS", "Windows 11");
	        extent.setSystemInfo("Browser", "Chrome");
	        extent.setSystemInfo("Test Name", context.getName());

	    }

	    public void onFinish(ITestContext context)
	    {
	        //Writing all logs into report
	        extent.flush();
	    }



	
	
	
}

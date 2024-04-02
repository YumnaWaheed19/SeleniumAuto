package ExtentReportDemo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicExtentReport {

	// Extent Reports is an open-source reporting library useful for test automation.
	//we need to create 3 variables to implement extent report
	ExtentSparkReporter htmlReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentSparkReporter("ExtentSparkReporter.html");
		extentReports = new ExtentReports();

		//attach html reporter
		extentReports.attachReporter(htmlReporter);

		//add environmental details
		extentReports.setSystemInfo("OS", "window 11");
		extentReports.setSystemInfo("user", "yumnawaheed");
		extentReports.setSystemInfo("browser", "chrome");

		//configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Extent Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm");

	}

	@Test
	public void launchBrowser() {
		extentTest =extentReports.createTest("Launch Chrome Browser and Open Url");
		Assert.assertTrue(true);
	}

	@Test
	public void verifyTitle() {
		extentTest=extentReports.createTest("Verify Title");
		Assert.assertTrue(false);
	}

	@Test
	public void verifyLogo() {
		extentTest=extentReports.createTest("Verify Logo");
		throw new SkipException("skipping this test case with exception...");

	}
	@Test
	public void verifyEmail() {
		extentTest=extentReports.createTest("Verify Email");
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void getTestResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			extentTest.fail(result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.YELLOW));
		}
	}
	
	@AfterTest
	public void tearDown() {
		extentReports.flush(); //Writes test information from the started reporters to their output view
	}
}
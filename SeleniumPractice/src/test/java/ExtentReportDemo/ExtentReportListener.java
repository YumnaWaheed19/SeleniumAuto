package ExtentReportDemo;

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

public class ExtentReportListener implements ITestListener {

	ExtentSparkReporter htmlReport;
	ExtentReports reports;
	ExtentTest test;
	public void configureReport() {
		htmlReport = new ExtentSparkReporter("ReportUsingListener.html");
		reports= new ExtentReports();
		reports.attachReporter(htmlReport); //attach htmlReports
		
		//add system information/environmental details
		reports.setSystemInfo("Machine", "TestPC");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("Host", "QA");
		
		//configuration to change look and feel
		htmlReport.config().setDocumentTitle("Extent Report Demo");
		htmlReport.config().setReportName("Extent Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm");
		
	}
	//invoked before the execution of test (called only 1 time)
	@Override
	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On Start Method invoked..." );

	}	
	
	//invoked on the execution of each test

	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method started..." + result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method succussfully invoked..." + result.getName());
		test= reports.createTest(result.getName() );
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Succeed ", ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method Failed..." + result.getName());
		test= reports.createTest(result.getName() );
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("on Test Skipped Method Invoke..." + result.getName());
		test= reports.createTest(result.getName() );
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Skipped ", ExtentColor.YELLOW));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	
	public void onFinish(ITestContext context) {
		System.out.println("On Finished method invoked..");
		reports.flush();
	}



}

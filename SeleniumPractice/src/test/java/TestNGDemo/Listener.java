package TestNGDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart Method invoked..." );

	}	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish test method invoked..");
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method started..." + result.getName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method succussfully invoked..." + result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on Test Skipped Method Invoke..." + result.getName());

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}




}

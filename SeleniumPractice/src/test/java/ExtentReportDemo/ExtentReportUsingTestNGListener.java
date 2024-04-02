package ExtentReportDemo;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ExtentReportUsingTestNGListener {

	/*TestNG Listener are the piece of code that listens the events occurring in the TestNG.
	By using TestNG Listener 'ITestLintener(Interface) or TestListenerAdapter(class) we can change 
	the default behavior of testNG and write our own implementation when a test fails or skips etc
	
	Extent reports using test listener
	1. create test class for test methods
	2. create testng.xml to execute test cases
	3. create testng listener class*/
	
	@Test
	public void testMethod1() {
		System.out.println("This is test method 1...");
		Assert.assertTrue(true);
	}
	
	@Test
	public void testMethod2() {
		System.out.println("This is test method 2...");
		Assert.assertTrue(true);
	}
	
	@Test
	public void testMethod3() {
		System.out.println("This is test method 3...");
		Assert.assertTrue(false);
	}
	
	@Test
	public void testMethod4() {
		System.out.println("This is test method 4...");
		throw new SkipException("The test method is skipped...");
	}
	
	
	
}

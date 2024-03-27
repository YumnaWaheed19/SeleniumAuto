package BatchTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HomeScreenTest {
	
	/*Running multiple test cases in a suite is called Batch Testing
	A test suite is a collection of test cases. Test suites help in
	grouping test cases.
	You can categorize test suites based on functionality,
	module, environment, or something else.
	In testNG we can use XML file to perform Batch Testing.*/
	
	//TestNG always creates an XML file to execute test cases.
	


	@Test
	public void launchApplication() {
		System.out.println("launch App");
	}
	@Test
	public void verifyLogo() {
		System.out.println("Verify logo ");
	}
	@Test
	public void verifyTitle() {
		System.out.println("Verify title ");

	}
}

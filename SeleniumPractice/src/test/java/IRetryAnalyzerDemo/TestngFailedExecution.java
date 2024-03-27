package IRetryAnalyzerDemo;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class TestngFailedExecution {
	
/*Why we re-run the test case when it fails?
There are multiple reasons why the test fails
Due to the network issue
Due to application downtime
Due to loading issue and etc
But if the script is failing due to xpath and some valid reason
then you have to maintain for re work on your scripts.

How We Re Run Failed Test Cases in Selenium in Case Of Failure?
1. Using testng-failed.xml (test-output -> test-faile.xml)
2. Using IRetryAnalyer interface that is part of TestNG and
we need to override retry method.
*/
	//@Test(retryAnalyzer = RetryAnalyzer.class)
	@Test
	public void retryAnalysisTest1() {
		Assert.assertTrue(false);
	}
	//@Test(retryAnalyzer = RetryAnalyzer.class)
	@Test
	public void retryAnalysisTest2() {
		Assert.assertTrue(true);
	}
	
	
}

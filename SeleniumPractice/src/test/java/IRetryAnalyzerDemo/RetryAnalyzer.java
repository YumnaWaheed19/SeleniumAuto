package IRetryAnalyzerDemo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
/*IRetryAnalyzer in TestNG is an interface that can retry the failed test*/
	int counterForRetryAttempt=0;
	int setMaxLimitOfRetry = 3;
	

	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(counterForRetryAttempt<setMaxLimitOfRetry) {
				counterForRetryAttempt++;
				return true;
			}
		}
		return false;
	}

}

package DataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name= "loginCredentails")
	public Object[][] loginCredentials(){
		return new Object[][] {
			{"standard_user", "secret_sauce"},
			{"problem_user","secret_sauce"}	,
			{"visual_user","secret_sauce"}	
		};
	}
}

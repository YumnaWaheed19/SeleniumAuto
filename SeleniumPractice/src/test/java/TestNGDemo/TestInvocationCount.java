package TestNGDemo;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestInvocationCount {
	/*@Test annotation- invocationCount attribute
In TestNG, InvocationCount attribute is used to run single
test case multiple time.(without using loop)
Syntax
@Test(invocationCount = num)
where num = number of times you want to run this
test method.*/



	//to check currently which invocation count is executing
	@Test(invocationCount = 2) // now this method/test will run 2 times
	public void testMethod1(ITestContext context) {

		int currentInvocationCount = context.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println("Executing:  " +currentInvocationCount);
		System.out.println("Test Method 1");
	}
	
	@Test(invocationCount = 5) // now this method/test wll run 5 times
	public void testMethod2(ITestContext context) {
		System.out.println("Test Method 2");
	}
}

package TestNGDemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngParameter {

	@Test
	@Parameters({"x","y"})
	public void sum(int a, int b) {
		System.out.println("Sum: "+  (a+b));
	}
	@Test
	@Parameters({"x","y"})
	public void subtraction(int a, int b) {
		System.out.println("Subtraction: " + (a-b));
	}
}

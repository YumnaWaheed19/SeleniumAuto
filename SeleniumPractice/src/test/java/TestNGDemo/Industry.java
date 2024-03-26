package TestNGDemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Industry {

	@Test
	@Parameters({"Industry"})
	public void IndustryName(String Ind){
		System.out.println("Industry: " + Ind);
	}
}

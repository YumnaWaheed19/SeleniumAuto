package TestNGDemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SoftwareCompany {

	@Test
	@Parameters({"SoftwareCompany"})
	public void SoftwareCompanyName(String sft){
		System.out.println("Software Company Name: " + sft);
	}
}

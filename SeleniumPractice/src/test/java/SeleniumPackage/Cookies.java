package SeleniumPackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Cookies {

	/*A HTTP cookie is comprised of information about the user and
	their preferences. It is a small piece of data sent from Web
	Application and stored in Web Browser, while the user is browsing
	that website.When a user visits a website with cookies enabled, the 
	website drops cookies and stores information in your system. All user 
	interactions will be saved in cookies.

	driver.manage().getCookies(); // Return The List of all Cookies
	driver.manage().getCookieNamed(arg0); //Return specific cookie
	according to name
	driver.manage().addCookie(arg0); //Create and add the cookie
	driver.manage().deleteCookie(arg0); // Delete specific cookie
	driver.manage().deleteCookieNamed(arg0); // Delete specific cookie
	according Name
	driver.manage().deleteAllCookies(); // Delete all cookies*/
	
	public String baseUrl ="https://www.amazon.com/";
	public WebDriver driver;
	
	@Test
	public void login() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.get(baseUrl);
		System.out.println("Get All Cookies");
		Set <Cookie> cookiesList= driver.manage().getCookies();
		System.out.println("Cookie Size: " +cookiesList.size());
		for (Cookie cookie : cookiesList) {
			System.out.println(cookie.getName() + ", " + cookie.getValue());		
		}
		//get specific cookie according to name
		System.out.println("Get Cookie by Name:  " +driver.manage().getCookieNamed("i18n-prefs"));

		System.out.println("\nAfter added new Cookie");
		
		//Create and Add cookie
		Cookie cookiesObj= new Cookie("TestCookie", "www.amazon.com");
		driver.manage().addCookie(cookiesObj);
		cookiesList= driver.manage().getCookies();
		System.out.println(cookiesList.size());
		
		//Capture all the cookies
		for (Cookie cookie : cookiesList) {
			System.out.println(cookie.getName() + ", " + cookie.getValue());		
		}

		//delete cookie by name
		//driver.manage().deleteCookie(cookiesObj);
		// driver.manage().deleteCookieNamed("New Cookie");
		driver.manage().deleteAllCookies();
			cookiesList= driver.manage().getCookies();

		//capture cookies after delete
		System.out.println("\n\nAfter delete Cookie:" +cookiesList.size());
		for (Cookie cookie : cookiesList) {
			System.out.println(cookie.getName() + ", " + cookie.getValue());		
		}
	}
}

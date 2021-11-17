package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.OrangePages;


public class TC7LoginUsingTest extends TestBase{
	
OrangePages  OrangeOR;
	
	@BeforeMethod
	public void loadpages()
	{
		OrangeOR = new OrangePages(driver);
	}
	
	@Test(priority=1)
 	public void login() throws InterruptedException
	{
		OrangeOR.GetLoginUserName(prop.getProperty("username"));
		Thread.sleep(2000);
		OrangeOR.GetPassword(prop.getProperty("password"));
		Thread.sleep(2000);
		OrangeOR.SetSubmitOnLoginButton();
		Thread.sleep(2000);

	}
}

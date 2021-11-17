package assignment;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OrangePages;

public class TC11ImplementITestListener extends TestBase{
	
	OrangePages OrangeOR;
 	@BeforeMethod
	public void loadpages() throws InterruptedException
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
		Thread.sleep(5000);
		OrangeOR.getDashBoardUsingTabName();
 		OrangeOR.getDashBoardConfirmtionUsingHeaderText();
 	}
 	
	@Test(priority=2 , retryAnalyzer=listener.RetryAnalyzer.class)

	public void method1() throws IOException, InterruptedException
	{
		
		
		String DashBoardHeader = OrangeOR.getDashBoardConfirmtionUsingHeaderText();
		boolean res = DashBoardHeader.equalsIgnoreCase("Dashbard");
		if(res)
		{
			Thread.sleep(4000);
			captureScreenShot(driver,"DashBoard Passed");
			Assert.assertTrue(true); 
			Reporter.log("User is in Dashboard Menu", true);;

		}
		 else
		{
			int i = 1; 
			captureScreenShot(driver,"DashBoard Failed Interation = "+ i);
			Assert.assertTrue(false); 
			Reporter.log("User is NOT in Dashboard Menu", true);
			i++;

		} 

}
	

}

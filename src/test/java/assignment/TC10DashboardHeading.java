package assignment;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.OrangePages;

public class TC10DashboardHeading extends TestBase{
	
OrangePages OrangeOR;
	
	@BeforeMethod
	public void loadpages()
	{
		OrangeOR = new OrangePages(driver);
	}
	
	@Test
	public void DashBaord() throws InterruptedException
	{
 		OrangeOR.GetLoginUserName(prop.getProperty("username"));
		Thread.sleep(2000);
		OrangeOR.GetPassword(prop.getProperty("password"));
		Thread.sleep(2000);
		OrangeOR.SetSubmitOnLoginButton();
		Thread.sleep(5000);
 		OrangeOR.getDashBoardUsingTabName();
		String DashBoardHeader = OrangeOR.getDashBoardConfirmtionUsingHeaderText();
		Assert.assertEquals("Dashboard", DashBoardHeader);
		Reporter.log("User is on Tab = " + DashBoardHeader);
		System.out.println("User is on Tab = " + DashBoardHeader);
	}
	

}

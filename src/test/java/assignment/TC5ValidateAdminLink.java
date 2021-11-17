package assignment;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.OrangePages;

public class TC5ValidateAdminLink {
	WebDriver driver;
	OrangePages op;

	@Test
	public void validateAdminLink() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		op = new OrangePages(driver);
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		String txt = driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]/b")).getText();
		Assert.assertEquals(txt, "Dashboard");
		System.out.println("We are in Dashboard");
		driver.findElement(By.cssSelector("a[id='menu_admin_viewAdminModule']")).click();
		Thread.sleep(2000);
		String txt1 = driver.findElement(By.cssSelector("a[id='menu_admin_UserManagement']")).getText();
		String txt2 = driver.findElement(By.cssSelector("a[id='menu_admin_Job']")).getText();
		String txt3 = driver.findElement(By.cssSelector("a[id='menu_admin_Organization']")).getText();
		String txt4 = driver.findElement(By.cssSelector("a[id='menu_admin_Qualifications']")).getText();
		Assert.assertEquals(txt1, "User Management");
		Assert.assertEquals(txt2, "Job");
		Assert.assertEquals(txt3, "Organization");
		Assert.assertEquals(txt4, "Qualifications");
		System.out.println("Validated text for User Management/Job/Organization/Qualifications links");
		
	}

}

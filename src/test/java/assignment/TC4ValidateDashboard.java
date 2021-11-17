package assignment;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.OrangePages;

public class TC4ValidateDashboard {

	WebDriver driver;
	OrangePages op;

	@Test
	public void validateDashboard() throws InterruptedException {
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
		String txt = driver.findElement(By.xpath("//*[@id='menu_dashboard_index']")).getText();
		Assert.assertEquals(txt, "Dashboard");
		System.out.println("We are in Dashboard");
	}
}

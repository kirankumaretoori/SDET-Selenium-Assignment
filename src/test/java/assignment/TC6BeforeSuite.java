package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC6BeforeSuite {

	WebDriver driver;

	@BeforeSuite
	public void URLLaunch() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@Test
	public void TestURL() {
		String Title = driver.getTitle();
		System.out.println(Title);

	}

	@AfterSuite
	public void Teardown() {
		driver.close();
	}

}
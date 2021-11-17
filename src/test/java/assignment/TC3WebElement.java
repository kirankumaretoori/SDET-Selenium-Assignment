package assignment;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.OrangePages;

public class TC3WebElement {
	WebDriver driver;
	OrangePages op;

	@Test
	public void loginPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		op = new OrangePages(driver);
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(10000);

		List<WebElement> CountForImages = op.getAllImagesXpath();
		int AllImagesXpath = CountForImages.size();
		Assert.assertTrue(AllImagesXpath == 5);
		Reporter.log("Total Number of Images on Login Page using xpath are " + AllImagesXpath, true);

		List<WebElement> CountForImages1 = op.getAllImagesCss();
		int AllImagesCss = CountForImages1.size();
		Assert.assertTrue(AllImagesXpath == 5);
		Reporter.log("Total Number of Images on Login Page using css are " + AllImagesCss, true);

		List<WebElement> Count = op.getAllLinksXpath();
		int AllLinksXpath = Count.size();
		Assert.assertTrue(AllLinksXpath == 6);
		Reporter.log("Total Number of Links on Login Page using xpath are " + AllLinksXpath, true);

		List<WebElement> Count1 = op.getAllLinksXpath();
		int AllLinksCss = Count1.size();
		Assert.assertTrue(AllLinksCss == 6);
		Reporter.log("Total Number of Links on Login Page using css are " + AllLinksCss, true);

		List<WebElement> CountTextBox = op.getAllTextBoxesXpath();
		int AllTextBoxXpath = CountTextBox.size();
		Assert.assertTrue(AllTextBoxXpath == 2);
		Reporter.log("Total Number of TextBoxes on Login Page using xpath are " + AllTextBoxXpath, true);

		List<WebElement> CountTextBox1 = op.getAllTextBoxesCss();
		int AllTextBoxCss = CountTextBox1.size();
		Assert.assertTrue(AllTextBoxCss == 2);
		Reporter.log("Total Number of TextBoxes on Login Page using css are " + AllTextBoxCss, true);

	}

}

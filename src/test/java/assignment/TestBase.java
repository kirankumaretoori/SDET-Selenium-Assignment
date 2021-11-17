package assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.apache.commons.io.FileUtils;

public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fileLoc;
	public static Properties prop;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void setUp(String browser, String url) {

		try {
			fileLoc = new FileInputStream("src/test/java/assignment/config.properties");
			prop = new Properties();
			prop.load(fileLoc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Browser  chrome Got Launched");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreenShot(WebDriver Driver, String tname) throws IOException {

		AShot Screen = new AShot();
		Screenshot sshot = Screen.shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);
		String Dest = System.getProperty("user.dir") + "/Screenshots/" + tname + ".jpeg";
		File FinalDestination = new File(Dest);
		ImageIO.write(sshot.getImage(), "jpeg", FinalDestination);

	}

}

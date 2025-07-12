package baseClass;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import genericUtilities.PropertyFileUtility;
import objectRepository.LoginPage;
import webDriverUtility.WebDriverUtility;

public class BaseClass {
	public WebDriver driver;
	public PropertyFileUtility putil = new PropertyFileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public static WebDriver sDriver = null; //for listeners
	@BeforeSuite
	public void configBS() {
		Reporter.log("Establish the DB connectivity", true);
	}

	@BeforeTest
	public void configBT() {
		Reporter.log("Pre-condition", true);
	}

	@BeforeClass
	public void configBC() throws IOException {
		Reporter.log("Launching the browser", true);

		String BROWSER = putil.getDataFromPropertiesFile("browser");
		String URL = putil.getDataFromPropertiesFile("url");

		// CROSS BROWSER TESTING
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sDriver = driver; //for listeners
		// Launching the URL
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		driver.get(URL);
	}

	@BeforeMethod
	public void configBM() throws IOException {
		Reporter.log("Login action started", true);
		String USERNAME = putil.getDataFromPropertiesFile("username");
		String PASSWORD = putil.getDataFromPropertiesFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.LoginAction(USERNAME, PASSWORD);
		Reporter.log("Login successful", true);
	}

	@AfterMethod
	public void configAM() throws InterruptedException {
		Reporter.log("LogOut action started", true);
		LoginPage lpg = new LoginPage(driver);
		wutil.waitForVisibilityOfWebelement(driver, lpg.getLogOut());
		lpg.LogoutAction();
		Reporter.log("Logged out successfully", true);
	}

	@AfterClass
	public void configAC() {
		driver.close();
		Reporter.log("Browser closed", true);
	}

	@AfterTest
	public void configAT() {
		Reporter.log("Post-condition", true);
	}

	@AfterSuite
	public void configAS() {
		Reporter.log("Disconnect DB", true);
	}
}

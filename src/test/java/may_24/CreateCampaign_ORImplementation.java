package may_24;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import genericUtilities.ExcelUtilities;
import genericUtilities.PropertyFileUtility;
import objectRepository.CampaignPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import webDriverUtility.WebDriverUtility;

public class CreateCampaign_ORImplementation {
	public static void main(String[] args) throws IOException, InterruptedException {
		PropertyFileUtility putil = new PropertyFileUtility();
		String Browser = putil.getDataFromPropertiesFile("browser");
		String URL = putil.getDataFromPropertiesFile("url");
		String UserName = putil.getDataFromPropertiesFile("username");
		String Password = putil.getDataFromPropertiesFile("password");

		WebDriver driver = null;
		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginAction(UserName, Password);
		HomePage hp = new HomePage(driver);
		hp.CreateACampaignBtn();
		Thread.sleep(2000);

		Random random = new Random();
		int randonInteger = random.nextInt(500);
		ExcelUtilities ExUtil = new ExcelUtilities();
		String campName = ExUtil.getDataFromExcel("sheet1", 1, 1);
		campName += randonInteger;
		String targetsize = ExUtil.getDataFromExcel("sheet1", 1, 3);
		String status = ExUtil.getDataFromExcel("sheet1", 1, 7);

		CampaignPage Cg = new CampaignPage(driver);
		Cg.CreateACampaign(campName, targetsize, status);
		
		// Verification
		WebElement message = Cg.getCpntoastmessage();
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.waitForVisibilityOfWebelement(driver, message);
		String msg = message.getText();
		Boolean status1 = msg.contains(campName);

		// Hard Assert
		Assert.assertEquals(status1, true, "Failed to create Campaign" + campName);
		Reporter.log("Successfully created the campaign", true);
		
		// Soft Assert implementation
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status1, false, "Failed to create the Campaign" + campName);
		soft.assertAll();

	}
}

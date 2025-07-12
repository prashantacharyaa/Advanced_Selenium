package june_22_Listeners;

import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import baseClass.BaseClass;
import genericUtilities.ExcelUtilities;
import listenerUtility.ListenerImplementationClass;
import objectRepository.CampaignPage;
import objectRepository.HomePage;
import webDriverUtility.WebDriverUtility;

@Listeners(ListenerImplementationClass.class)
public class CreateCampaign_Listeners extends BaseClass {
	@Test
	public void CreateCampaignTest() throws IOException, InterruptedException {
//		PropertyFileUtility putil = new PropertyFileUtility();
//		String Browser = putil.getDataFromPropertiesFile("browser");
//		String URL = putil.getDataFromPropertiesFile("url");
//		String UserName = putil.getDataFromPropertiesFile("username");
//		String Password = putil.getDataFromPropertiesFile("password");

//		WebDriver driver = null;
//		if (Browser.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (Browser.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		} else if (Browser.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get(URL);

//		LoginPage lp = new LoginPage(driver);
//		lp.LoginAction(UserName, Password);
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

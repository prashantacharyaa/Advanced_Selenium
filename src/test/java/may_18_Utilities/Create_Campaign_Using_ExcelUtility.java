package may_18_Utilities;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelUtilities;
import genericUtilities.JavaUtilities;
import genericUtilities.PropertyFileUtility;

public class Create_Campaign_Using_ExcelUtility {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		PropertyFileUtility pfu = new PropertyFileUtility();
		String url = pfu.getDataFromPropertiesFile("url");
		String unm = pfu.getDataFromPropertiesFile("username");
		String pwd =pfu.getDataFromPropertiesFile("password");
						
		// Invoke Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Read Data from Excel using Excel Utility
		ExcelUtilities eUtil = new ExcelUtilities();
		String camp = eUtil.getDataFromExcel("Sheet1", 1, 0);
		String target = eUtil.getDataFromExcel("Sheet1", 1, 1);
				
		// To generate Random number
		JavaUtilities ju = new JavaUtilities();
		int randonInteger = ju.getRandomNumber();
		
		// Login to the Application
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(unm);
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click();
		Thread.sleep(3000);

		// Create Campaign
		driver.findElement(By.xpath("//span[text() = 'Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(camp + randonInteger);
		WebElement targetSize = driver.findElement(By.name("targetSize"));
		targetSize.clear();
		targetSize.sendKeys(target);
		driver.findElement(By.xpath("//button[text() = 'Create Campaign']")).click();
	}

}

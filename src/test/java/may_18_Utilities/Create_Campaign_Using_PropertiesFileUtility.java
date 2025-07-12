package may_18_Utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.PropertyFileUtility;

public class Create_Campaign_Using_PropertiesFileUtility {

	public static void main(String[] args) throws IOException, ParseException {
		PropertyFileUtility pfu = new PropertyFileUtility();
		String browser = pfu.getDataFromPropertiesFile("browser");
		String url = pfu.getDataFromPropertiesFile("url");
		String unm = pfu.getDataFromPropertiesFile("username");
		String pwd = pfu.getDataFromPropertiesFile("password");
		
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// To generate Random number
		Random random = new Random();
		int randomInteger = random.nextInt(500);
		System.out.println(randomInteger);

		// Login to the Application
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(unm);
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click();

		// Create Campaign
		driver.findElement(By.xpath("//span[text() = 'Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Save Trees" + randomInteger);
		WebElement targetSize = driver.findElement(By.name("targetSize"));
		targetSize.clear();
		targetSize.sendKeys("400");
		driver.findElement(By.xpath("//button[text() = 'Create Campaign']")).click();

	}
}

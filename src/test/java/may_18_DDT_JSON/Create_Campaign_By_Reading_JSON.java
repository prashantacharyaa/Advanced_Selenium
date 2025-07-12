package may_18_DDT_JSON;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_Campaign_By_Reading_JSON {

	public static void main(String[] args) throws IOException, ParseException {
		// Step 1 : Get access of physical file using file reader
		FileReader fr = new FileReader(
				"C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\Advanced Selenium\\JSONCommonData.json");
		// Parse the JSON Physical file into Java File using JSONParser class.
		JSONParser parser = new JSONParser();

		Object object = parser.parse(fr);

		// Convert Java Object to JSONObject using downcasting.
		JSONObject jsonobj = (JSONObject) object;

		// Read the data using get() by passing the Key.
		String browser = jsonobj.get("browser").toString();
		System.out.println(browser);
		String url = jsonobj.get("url").toString();
		System.out.println(url);
		String unm = jsonobj.get("username").toString();
		System.out.println(unm);
		String pwd = jsonobj.get("password").toString();
		System.out.println(pwd);

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
		driver.findElement(By.name("campaignName")).sendKeys("Save Trees"+randomInteger);
		WebElement targetSize = driver.findElement(By.name("targetSize"));
		targetSize.clear();
		targetSize.sendKeys("400");
		driver.findElement(By.xpath("//button[text() = 'Create Campaign']")).click();
	}

}

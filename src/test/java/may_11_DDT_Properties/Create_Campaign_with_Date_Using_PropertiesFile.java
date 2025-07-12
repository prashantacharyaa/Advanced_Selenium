package may_11_DDT_Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Create_Campaign_with_Date_Using_PropertiesFile {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Invoke Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\CRM\\common.properties");
		// 2. Create object of the properties file
		Properties p = new Properties();
		// 3. Load all the keys
		p.load(fis);
		// By taking help of the key read the data
		String browser = p.getProperty("browser");
		System.out.println(browser);
		String url = p.getProperty("url");
		System.out.println(url);
		String un = p.getProperty("username");
		System.out.println(un);
		String pw = p.getProperty("password");
		System.out.println(pw);
		
		// driver.get("http://49.249.28.218:8098/");

		// To generate Random number
		Random random = new Random();
		int randonInteger = random.nextInt(500);
		System.out.println(randonInteger);

		// Login to the Application
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.id("inputPassword")).sendKeys(pw);
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click();
		Thread.sleep(3000);

		// Create Campaign
		driver.findElement(By.xpath("//span[text() = 'Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Save Trees"+randonInteger);
		WebElement targetSize = driver.findElement(By.name("targetSize"));
		targetSize.clear();
		targetSize.sendKeys("500");
		
		// Calendar Control
		// Capture Current System Date
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = sdf.format(date);
		System.out.println(currentDate);
		
		// Capture Current System Date 30 days after
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String expectedDate = sdf.format(cal.getTime());
		System.out.println(expectedDate);
		
		WebElement calendar = driver.findElement(By.name("expectedCloseDate"));
		calendar.sendKeys(expectedDate);
		driver.findElement(By.xpath("//button[text() = 'Create Campaign']")).click();
	}

}

package may_17_DDT_Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Create_Campaign_By_Reading_Excel_Data {

	public static void main(String[] args) throws IOException, InterruptedException {

		// 1. Get the Java representation of the Physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\CRM\\common.properties");

		// 2. Create object of the properties file
		Properties p = new Properties();

		// 3. Load all the keys
		p.load(fis);

		// By taking help of the key read the data
		//String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		
		// Invoke Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Step 1: Get the Java Representation object of the Physical file
		FileInputStream fis1 = new FileInputStream(
			"C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\Advanced Selenium\\file_example_XLS_50 - Copy.xls");
		// Step 2: Open Excel in Read Mode.
		Workbook wb = WorkbookFactory.create(fis1);
		// Step 3: Get control of the required sheet
		Sheet sh = wb.getSheet("Sheet1");
		// Step 4: Get the Row control
		Row r = sh.getRow(1);
		// Step 5: Get access to Cell.
		Cell c1 = r.getCell(0);
		Cell c2 = r.getCell(1);
		
		String camp = c1.getStringCellValue();
		String target = c2.getStringCellValue();
		
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
		driver.findElement(By.name("campaignName")).sendKeys(camp + randonInteger);
		WebElement targetSize = driver.findElement(By.name("targetSize"));
		targetSize.clear();
		targetSize.sendKeys(target);
		driver.findElement(By.xpath("//button[text() = 'Create Campaign']")).click();
	}

}

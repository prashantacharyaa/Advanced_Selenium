package may_10_CRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_Contact {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\CRM\\common.properties");

		// 2. Create object of the properties file
		Properties p = new Properties();

		// 3. Load all the keys
		p.load(fis);

		// By taking help of the key read the data
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
		    driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
		    driver = new EdgeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
		    driver = new FirefoxDriver();
		}else {
		    driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\Advanced Selenium\\Campaign.xlsx");
			// Step 2: Open Excel in Read Mode.
			Workbook wb = WorkbookFactory.create(fis1);
			// Step 3: Get control of the required sheet
			Sheet sh = wb.getSheet("Contacts");
			// Step 4: Get the Row control
			Row r = sh.getRow(1);
			// Step 5: Get access to Cell.
			Cell c1 = r.getCell(0);
			Cell c2 = r.getCell(1);
			Cell c3 = r.getCell(2);
			Cell c4 = r.getCell(3);
			String org = c1.getStringCellValue();
			String title = c2.getStringCellValue();
			String c_Name = c3.getStringCellValue();
			String Mob = c4.getStringCellValue();
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
			
			// Create Contacts
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//span[text() = 'Create Contact']")).click();
			driver.findElement(By.name("organizationName")).sendKeys(org);
			driver.findElement(By.name("title")).sendKeys(title);
			driver.findElement(By.name("contactName")).sendKeys(c_Name);
			driver.findElement(By.name("mobile")).sendKeys(Mob);
			driver.findElement(By.xpath("(//button[@type = 'button'])[2]")).click();
			
			// Switch to Child Window to Select Campaign
			Set<String> allwinIDs = driver.getWindowHandles();
			Iterator<String> it = allwinIDs.iterator();
			String parentID = it.next();
			String childID = it.next();
			driver.switchTo().window(childID);				
			WebElement campaign = driver.findElement(By.id("search-criteria"));
			Select s = new Select(campaign);
			s.selectByValue("campaignName");
			Sheet sh1 = wb.getSheet("Sheet1");
			Row r1 = sh1.getRow(1);
			Cell c5 = r1.getCell(0);
			String camp_Name = c5.getStringCellValue();
			driver.findElement(By.id("search-input")).sendKeys(camp_Name);
			driver.findElement(By.xpath("//button[@onclick = \"selectCampaign('CAM02341', 'Save Girl Child')\"]")).click(); // Click on Select
			driver.switchTo().window(parentID);	
			driver.findElement(By.xpath("//button[text() = 'Create Contact']")).click();
			
	}

}

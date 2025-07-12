package may_10_CRM;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_Leads {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Login to the Application
		driver.get("http://49.249.28.218:8098/"); 										// Hit the Ninza CRM Application URL
		driver.findElement(By.id("username")).sendKeys("rmgyantra"); 					// Enter the Username/LoginID
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999"); 				// Enter the Password
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click(); 			// Click on the SignIn button
		Thread.sleep(3000);
		
		// Create Leads
		driver.findElement(By.linkText("Leads")).click();								// Click on the Leads Tab
		driver.findElement(By.xpath("//span[text() = 'Create Lead']")).click();			// Click on the Create Lead button
		driver.findElement(By.name("name")).sendKeys("Test Lead");						// Enter the Lead Name
		driver.findElement(By.name("company")).sendKeys("QSP");							// Enter the Company name
		driver.findElement(By.name("leadSource")).sendKeys("QSP-Mumbai");				// Enter the Lead Source Name
		driver.findElement(By.name("industry")).sendKeys("Certification & Training");	// Enter the Industry
		WebElement revenue = driver.findElement(By.name("annualRevenue"));
		revenue.clear();
		revenue.sendKeys("1000000000");													// Enter Revenue
		WebElement noOfEmployees = driver.findElement(By.name("noOfEmployees"));		
		noOfEmployees.clear();
		noOfEmployees.sendKeys("500");													// Enter number of Employees
		driver.findElement(By.name("phone")).sendKeys("9987654321");					// Enter Phone number
		driver.findElement(By.name("email")).sendKeys("test@qsp.com");					// Enter Email Address
		driver.findElement(By.name("leadStatus")).sendKeys("Active");					// Enter Lead Status
		WebElement rating = driver.findElement(By.name("rating"));
		rating.clear();
		rating.sendKeys("1");															// Enter Rating
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();			// Click on Add Button to Select Campaign
		
		//Handling Multiple Windows
		Set<String> allwinIDs = driver.getWindowHandles();
		Iterator<String> it = allwinIDs.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);												// Switch to Child Window
		WebElement campaign = driver.findElement(By.id("search-criteria"));
		Select s = new Select(campaign);
		s.selectByValue("campaignName");												// Search by Campaign Name
		driver.findElement(By.id("search-input")).sendKeys("Save Girl Child");
		driver.findElement(By.xpath("//button[@onclick = \"selectCampaign('CAM02341', 'Save Girl Child')\"]")).click(); // Click on Select
		driver.switchTo().window(parentID);												// Switch to Parent Window
		driver.findElement(By.xpath("//button[text() = 'Create Lead']")).click();		// Click on Create Lead Button
		String success = driver.findElement(By.xpath("//div[contains(text(), 'Successfully Added')]")).getText();
		System.out.println(success);
	}

}

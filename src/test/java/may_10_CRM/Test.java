package may_10_CRM;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Login to the Application
		driver.get("http://49.249.28.218:8098/"); 										// Hit the Ninza CRM Application URL
		driver.findElement(By.id("username")).sendKeys("rmgyantra"); 					// Enter the Username/LoginID
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999"); 				// Enter the Password
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click(); 			// Click on the SignIn button
		Thread.sleep(3000);
		driver.findElement(By.linkText("Leads")).click();								// Click on the Leads Tab
		driver.findElement(By.xpath("//span[text() = 'Create Lead']")).click();			// Click on the Create Lead button
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();			// Click on Add Button to Select Campaign
		
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		
		WebElement campaign = driver.findElement(By.id("search-criteria"));
		Select s = new Select(campaign);
		s.selectByValue("campaignName");												// Search by Campaign Name
		driver.findElement(By.id("search-input")).sendKeys("Save Girl Child");
		driver.findElement(By.xpath("//button[@onclick = \"selectCampaign('CAM02341', 'Save Girl Child')\"]")).click(); // Click on Select
		driver.switchTo().window(windows.get(0));												
		System.out.println(driver.getTitle());
	}

}

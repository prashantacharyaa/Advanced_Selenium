package may_10_CRM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_Product {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Login to the Application
		driver.get("http://49.249.28.218:8098/"); 								// Hit the Ninza CRM Application URL
		driver.findElement(By.id("username")).sendKeys("rmgyantra"); 			// Enter Username/LoginID
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999"); 		// Enter Password
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click(); 	// Click on the SignIn button
		Thread.sleep(3000);

		// Create a Product
		driver.findElement(By.xpath("//a[text() = 'Products']")).click(); 		// Click on Products tab
		driver.findElement(By.xpath("//span[text() = 'Add Product']")).click(); // Click on Add Product Button
		driver.findElement(By.name("productName")).sendKeys("Google Pixel 9a"); // Enter the Product Name

		WebElement SelectCategory = driver.findElement(By.name("productCategory"));
		Select s = new Select(SelectCategory);
		s.selectByValue("Electronics"); 										// Select the Product Category
		driver.findElement(By.name("quantity")).sendKeys("50"); 				// Enter Product Quantity
		WebElement unit_Price = driver.findElement(By.name("price"));
		unit_Price.clear();
		unit_Price.sendKeys("50000000");										// Enter Product Price Per Unit

		WebElement vendor = driver.findElement(By.name("vendorId"));
		Select v = new Select(vendor);
		v.selectByValue("VID_009"); 											// Select the Vendor
		driver.findElement(By.xpath("//button[@type='submit']")).click(); 		// Click on the Add Button
	}

}

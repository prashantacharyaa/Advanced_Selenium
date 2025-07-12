package may_10_CRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Create_Campaign {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Login to the Application
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text() = 'Sign In']")).click();
		Thread.sleep(3000);
		
		/*Alert a = driver.switchTo().alert();
		a.accept();
		a.dismiss();
		a.getText();*/
		
		// Create Campaign
		driver.findElement(By.xpath("//span[text() = 'Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Save Trees");
		WebElement targetSize = driver.findElement(By.name("targetSize"));
		targetSize.clear();
		targetSize.sendKeys("400");
		driver.findElement(By.xpath("//button[text() = 'Create Campaign']")).click();
	}

}

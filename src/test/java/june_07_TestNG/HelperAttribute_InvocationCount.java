package june_07_TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_InvocationCount {
	@Test(invocationCount = 5)
	public void login() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.instagram.com/");
		Reporter.log("Successfully navigated to Instagram", true);
		Thread.sleep(2000);
		driver.quit();
	}
	@Test(invocationCount = 3)
	public void login1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		Reporter.log("Successfully navigated to Flipkart", true);
		Thread.sleep(2000);
		driver.quit();
	}
}

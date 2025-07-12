package webDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void waitForVisibilityOfWebelement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToFrame(WebDriver driver, String nameorID) {
		driver.switchTo().frame(nameorID);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String visibletext) {
		Select sel = new Select(element);
		sel.selectByContainsVisibleText(visibletext);
	}

	public void toSwitchToWindow(WebDriver driver) {
		String parentid = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		allids.remove(parentid);
		for (String window : allids) {
			driver.switchTo().window(window);
		}
	}

	public void toSwitchToParent(WebDriver driver) {
		Set<String> allwinIDs = driver.getWindowHandles();
		Iterator<String> it = allwinIDs.iterator();
		String parentID = it.next();
		driver.switchTo().window(parentID);
//		String parentid = driver.getWindowHandle();
//		Set<String> allids = driver.getWindowHandles();
//		//allids.remove(parentid);
//		for (String window : allids) {
//			driver.switchTo().window(window);
//		}
		
	}

	public void takeScreenshotOfWebPage(WebDriver driver, String ssName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Advance_Selenium/ErrorShots/" + ssName + ".png");
		FileHandler.copy(src, dest);
	}
}

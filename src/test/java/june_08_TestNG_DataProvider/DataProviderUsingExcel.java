package june_08_TestNG_DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsingExcel {
@Test(dataProvider = "getDataFromExcel")
public void getPriceOfProd(String bName, String pName) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(bName, Keys.ENTER);
	
	//Capture the Price of the Product
	String dynamicXpath = "//span[text()='"+pName+"']/../../../../../../../div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span[1]/span[2]";
	String price = driver.findElement(By.xpath(dynamicXpath)).getText();
	System.out.println(pName);
	System.out.println(price);
	Thread.sleep(4000);
	driver.quit();
}		
	@DataProvider
	public Object[][] getDataFromExcel() throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\Advanced Selenium\\Product.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("Product");
		int rowCount = sh.getLastRowNum();
		Object[][] objArray=new Object[rowCount][2];
		for(int i=0;i<rowCount;i++) {
			objArray[i][0]=sh.getRow(i+1).getCell(0).getStringCellValue();
			objArray[i][1]=sh.getRow(i+1).getCell(1).getStringCellValue();
		}
		return objArray;
	}
	
}

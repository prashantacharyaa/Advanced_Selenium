package june_15_TestNG_ObjectRepository;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import genericUtilities.ExcelUtilities;
import genericUtilities.JavaUtilities;
import objectRepository.HomePage;
import objectRepository.ProductsPage;
import webDriverUtility.WebDriverUtility;

public class CreateProducts extends BaseClass {
	@Test
	private void AddNewProduct() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.ProductsTab();
		ExcelUtilities ExUtil = new ExcelUtilities();
		JavaUtilities ju = new JavaUtilities();
		WebDriverUtility wu = new WebDriverUtility();
		wu.waitForPageToLoad(driver);

		int rno = ju.getRandomNumber();
		String ProductName = ExUtil.getDataFromExcel("Products", 1, 0);
		ProductName += rno;
		String SelectCategory = ExUtil.getDataFromExcel("Products", 1, 1);
		String Quantity = ExUtil.getDataFromExcel("Products", 1, 2);
		String PricePerUnit = ExUtil.getDataFromExcel("Products", 1, 3);
		String SelectVendor = ExUtil.getDataFromExcel("Products", 1, 4);

		ProductsPage pp = new ProductsPage(driver);
		pp.add_Product(ProductName, SelectCategory, Quantity, PricePerUnit, SelectVendor);
	}
}

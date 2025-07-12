package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webDriverUtility.WebDriverUtility;

public class ProductsPage {
	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;// pointing towards same addr
		PageFactory.initElements(driver, this);// initilizes @FindBy
	}

	@FindBy(xpath = "//span[text()='Add Product']")
	private WebElement AddNewProduct;

	@FindBy(name = "productName")
	private WebElement ProductName;

	@FindBy(name = "productCategory")
	private WebElement SelectCategory;

	@FindBy(name = "quantity")
	private WebElement Quantity;

	@FindBy(name = "price")
	private WebElement PricePerUnit;

	@FindBy(name = "vendorId")
	private WebElement SelectVendor;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement SubmitAddProduct;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddNewProduct() {
		return AddNewProduct;
	}

	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getSelectCategory() {
		return SelectCategory;
	}

	public WebElement getQuantity() {
		return Quantity;
	}

	public WebElement getPricePerUnit() {
		return PricePerUnit;
	}

	public WebElement getSelectVendor() {
		return SelectVendor;
	}

	public WebElement getSubmitAddProduct() {
		return SubmitAddProduct;
	}

	public void add_Product(String prodName, String selectCategory, String quantity, String unitPrice,
			String selectVendor) {
		AddNewProduct.click();
		ProductName.sendKeys(prodName);
		WebDriverUtility wu = new WebDriverUtility();
		
		wu.selectByValue(SelectCategory, selectCategory);
//		SelectCategory.sendKeys(selectCategory);
		Quantity.clear();
		Quantity.sendKeys(quantity);
		PricePerUnit.clear();
		PricePerUnit.sendKeys(unitPrice);
		
		wu.selectByVisibleText(SelectVendor, selectVendor);
//		SelectVendor.sendKeys(selectVendor);
		SubmitAddProduct.click();

	}

}

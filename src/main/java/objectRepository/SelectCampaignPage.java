package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.ExcelUtilities;

public class SelectCampaignPage {
	WebDriver driver;

	public SelectCampaignPage(WebDriver driver) {
		this.driver = driver;// pointing towards same addr
		PageFactory.initElements(driver, this);// initilizes @FindBy
	}
	@FindBy(id = "search-criteria")
	private WebElement Campaign;
	@FindBy(id = "search-input")
	private WebElement Search_input;
	@FindBy(xpath = "(//button[text() = 'Select'])[1]")
	private WebElement Select_CampBtn;
	
	
	public WebElement getCampaign() {
		return Campaign;
	}

	public WebElement getSearch_input() {
		return Search_input;
	}
	
	public WebElement getSelect_CampBtn() {
		return Select_CampBtn;
	}

	public void SelectCampaign() throws Throwable {
		Select s = new Select(Campaign);
		s.selectByValue("campaignName");
//		Thread.sleep(2000);
		ExcelUtilities eu = new ExcelUtilities();
		String Campaign_Name = eu.getDataFromExcel("Sheet1", 1, 1);
		Search_input.sendKeys(Campaign_Name);
		Select_CampBtn.click();
	}
}

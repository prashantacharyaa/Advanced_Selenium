package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	WebDriver driver;

	public CampaignPage(WebDriver driver) {
		this.driver = driver;// pointing towards same addr
		PageFactory.initElements(driver, this);// initilizes @FindBy
	}

	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement CreateCampaign;

	@FindBy(name = "campaignId")
	private WebElement Cid;
	@FindBy(name = "campaignName")
	private WebElement Cname;
	@FindBy(name = "campaignStatus")
	private WebElement Cstatus;
	@FindBy(name = "targetSize")
	private WebElement CtargetSize;
	@FindBy(name = "expectedCloseDate")
	private WebElement Cdate;
	@FindBy(name = "targetAudience")
	private WebElement CtargetAudience;
	@FindBy(xpath = "//textarea[@name= 'description']")
	private WebElement Cdescription;
	@FindBy (xpath = "//div[@role='alert']")
	private WebElement cpntoastmessage;
	
	
	@FindBy(xpath = "//button[text()='Create Campaign'] ")
	private WebElement CSubmitcampaign;
	
	
	/*
	 * public WebElement getCreateCampaign() { return CreateCampaign; }
	 */

	public WebElement getCid() {
		return Cid;
	}

	public WebElement getCname() {
		return Cname;
	}

	public WebElement getCstatus() {
		return Cstatus;
	}

	public WebElement getCtargetSize() {
		return CtargetSize;
	}

	public WebElement getCdate() {
		return Cdate;
	}

	public WebElement getCtargetAudience() {
		return CtargetAudience;
	}

	public WebElement getDescription() {
		return Cdescription;
	}

	public WebElement getSubmitcampaign() {
		return CSubmitcampaign;
	}
	
	public WebElement getCpntoastmessage() {
		return cpntoastmessage;
	}


	public void CreateACampaign(String name, String status, String targetSize) throws InterruptedException
	{
		//CreateCampaign.click();
		Thread.sleep(2000);
		//Cid.sendKeys(id);
		Cname.sendKeys(name);
		CtargetSize.sendKeys(targetSize);
		Cstatus.sendKeys(status);
		//Cdate.sendKeys(date);
		//CtargetAudience.sendKeys(targetAudience);
		//Cdescription.sendKeys(description);
		CSubmitcampaign.click();
		Thread.sleep(6000);
		
	}
 
	public void CreateACampaignwithDate(String name, String cstatus, String targetSize, String date, 
			String targetAudience, String description) throws InterruptedException {

		//CreateCampaign.click();
		Thread.sleep(2000);
		//Cid.sendKeys(id);
		Cname.sendKeys(name);
		CtargetSize.clear();
		CtargetSize.sendKeys(targetSize);
		Cstatus.sendKeys(cstatus);
		Cdate.sendKeys(date);
		CtargetAudience.sendKeys(targetAudience);
		Cdescription.sendKeys(description);
		CSubmitcampaign.click();
		Thread.sleep(6000);
	}

	public String getCpntoastmessage1() {
		
		return cpntoastmessage.getText();
	}
} 

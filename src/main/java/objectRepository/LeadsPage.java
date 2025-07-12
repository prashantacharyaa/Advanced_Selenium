package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	WebDriver driver;

	public LeadsPage(WebDriver driver) {
		this.driver = driver;// pointing towards same addr
		PageFactory.initElements(driver, this);// initilizes @FindBy
	}

	@FindBy(xpath = "//span[text()= 'Create Lead']")
	private WebElement Create_Lead1;

	public WebElement getCreate_Lead1() {
		return Create_Lead1;
	}

	@FindBy(name = "name")
	private WebElement Lead_Name;

	public WebElement getLead_Name() {
		return Lead_Name;
	}

	@FindBy(name = "company")
	private WebElement Company;

	public WebElement getCompany() {
		return Company;
	}

	@FindBy(name = "leadSource")
	private WebElement Lead_Source;

	public WebElement getLead_Source() {
		return Lead_Source;
	}

	@FindBy(name = "industry")
	private WebElement Industry;

	public WebElement getIndustry() {
		return Industry;
	}

	@FindBy(name = "phone")
	private WebElement Phone;

	public WebElement getPhone() {
		return Phone;
	}

	@FindBy(name = "email")
	private WebElement Email;

	public WebElement getEmail() {
		return Email;
	}

	@FindBy(name = "leadStatus")
	private WebElement Lead_Status;

	public WebElement getLead_Status() {
		return Lead_Status;
	}

	@FindBy(name = "rating")
	private WebElement Rating;

	public WebElement getRating() {
		return Rating;
	}

	@FindBy(name = "assignedTo")
	private WebElement AssignedTo;

	public WebElement getAssignedTo() {
		return AssignedTo;
	}

	@FindBy(name = "city")
	private WebElement City;

	public WebElement getCity() {
		return City;
	}

	@FindBy(xpath = "(//button[@type = 'button'])[2]")
	private WebElement SelectCampBtn;

	public WebElement getSelectCampBtn() {
		return SelectCampBtn;
	}

	@FindBy(xpath = "//button[text()= 'Create Lead']")
	private WebElement CreateLead_SubmitBtn;

	public WebElement getCreateLead_SubmitBtn() {
		return CreateLead_SubmitBtn;
	}

	public void Create_Lead(String name, String company, String source, String industry, String phone, String email,
			String status, String rating, String assignedTo, String city) {

		Create_Lead1.click();
		Lead_Name.sendKeys(name);
		Company.sendKeys(company);
		Lead_Source.sendKeys(source);
		Industry.sendKeys(industry);
		Phone.sendKeys(phone);
		Email.sendKeys(email);
		Lead_Status.sendKeys(status);
		Rating.clear();
		Rating.sendKeys(rating);
		AssignedTo.sendKeys(assignedTo);
		City.sendKeys(city);
		SelectCampBtn.click();
	}

	public void create_Lead() {
		CreateLead_SubmitBtn.click();
	}

}

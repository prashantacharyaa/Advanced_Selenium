package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;// pointing towards same addr
		PageFactory.initElements(driver, this);// initilizes @FindBy
	}

	@FindBy(linkText = "Contacts")
	private WebElement Contacts;
	@FindBy(xpath = "//span[text() = 'Create Contact']")
	private WebElement AddNewContact;
	@FindBy(name = "contactId")
	private WebElement Contact_id;
	@FindBy(name = "contactName")
	private WebElement Contact_name;
	@FindBy(name = "organizationName")
	private WebElement Org_Name;
	@FindBy(name = "mobile")
	private WebElement Mobile;
	@FindBy(name = "title")
	private WebElement Title;
	@FindBy(name = "email")
	private WebElement Email;
	@FindBy(name = "department")
	private WebElement Department;
	@FindBy(xpath = "(//button[@type = 'button'])[2]")
	private WebElement SelectCampaign;
	@FindBy(xpath = ("//button[text() = 'Create Contact']"))
	private WebElement CreateContact;

	public WebElement getContacts() {
		return Contacts;
	}

	public WebElement getAddNewContact() {
		return AddNewContact;
	}

	public WebElement getContact_id() {
		return Contact_id;
	}

	public WebElement getContact_name() {
		return Contact_name;
	}

	public WebElement getOrg_Name() {
		return Org_Name;
	}

	public WebElement getMobile() {
		return Mobile;
	}

	public WebElement getTitle() {
		return Title;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getDepartment() {
		return Department;
	}

	public WebElement getCreateContact() {
		return CreateContact;
	}

	public void Contacts_Tab() {
		Contacts.click();
	}

	public void NewContactbtn() {
		AddNewContact.click();
	}

	public void CreateContact(String organisationName, String title, String contactName, String mobile, String email,
			String department) {
//		Contact_id.sendKeys(contactId);
		Contact_name.sendKeys(contactName);
		Org_Name.sendKeys(organisationName);
		Mobile.sendKeys(mobile);
		Title.sendKeys(title);
		Email.sendKeys(email);
		Department.sendKeys(department);
		SelectCampaign.click();

	}

	public void create_contact() {
		CreateContact.click();
	}
}

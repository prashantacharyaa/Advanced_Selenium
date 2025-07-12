package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;// pointing towards same addr
		PageFactory.initElements(driver, this);// initilizes @FindBy
	}

	// Autohealing implementation
	@FindAll({ @FindBy(id = "usernam"), @FindBy(name = "username") })
	private WebElement usernametf;
	@FindBy(name = "password")
	private WebElement passwordtf;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement LoginButton;

	// Accessing webelemets using getters
	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public void LoginAction(String username, String password) {
		usernametf.sendKeys(username);
		passwordtf.sendKeys(password);
		LoginButton.click();
	}

	@FindBy(xpath = "//div[@class = 'user-icon']")
	private WebElement LogOut;

	public WebElement getLogOut() {
		return LogOut;
	}

	public void LogoutAction() {
		LogOut.click();
	}

}

package june_15_TestNG_ObjectRepository;

import org.testng.Reporter;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class LoginPage_ORImplementation extends BaseClass{
	@Test
	public void Login() throws Throwable {
		Thread.sleep(5000);
		Reporter.log("Login Successful", true);
	}
}

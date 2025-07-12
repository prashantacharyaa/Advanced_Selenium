package june_07_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_DependsOnMethod {
	@Test(enabled = true)
	public void createAccount() {
		Reporter.log("Account created successfully", true);
	}

	@Test(dependsOnMethods = "createAccount", enabled = false)
	public void editAccount() {
		Reporter.log("Account edited successfully", true);
	}

	@Test(dependsOnMethods = "createAccount", enabled = true)
	public void deleteAccount() {
		Reporter.log("Account deleted successfully", true);
	}
}

package june_07_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_Priority {
	@Test(priority = -4)
	public void Flipkart() {
		Reporter.log("Flipkart executed", true);
	}

	@Test(priority = -1)
	public void Blinkit() {
		Reporter.log("Blinkit executed", true);
	}

	@Test(priority = 0)
	public void Myntra() {
		Reporter.log("Myntra executed", true);
	}

	@Test(priority = -3)
	public void Amazon() {
		Reporter.log("Amazon executed", true);
	}
}

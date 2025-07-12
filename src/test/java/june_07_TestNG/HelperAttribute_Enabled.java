package june_07_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_Enabled {
	@Test(enabled = false)
	public void Flipkart() {
		Reporter.log("Flipkart executed", true);
	}

	@Test(enabled = false)
	public void Blinkit() {
		Reporter.log("Blinkit executed", true);
	}

	@Test(enabled = false)
	public void Myntra() {
		Reporter.log("Myntra executed", true);
	}

	@Test(enabled = true)
	public void Amazon() {
		Reporter.log("Amazon executed", true);
	}
}

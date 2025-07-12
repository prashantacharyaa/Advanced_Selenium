package listenerUtility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import baseClass.BaseClass;
import genericUtilities.JavaUtilities;

public class ListenerImplementationClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("=====Report Configuration=====", true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// every @Test annotated method
		String methodName = result.getMethod().getMethodName();
		Reporter.log("=====" + methodName + "=====STARTED=====", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("=====" + methodName + "=====SUCCESS=====", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		JavaUtilities jutil = new JavaUtilities();
		String datetime = jutil.getSystemDateAndTimeForScreenshot();

		TakesScreenshot tks = (TakesScreenshot) BaseClass.sDriver;
		File temp = tks.getScreenshotAs(OutputType.FILE);
		File perm = new File("./ErrorShots/" + methodName + datetime + ".png");

		try {
			org.openqa.selenium.io.FileHandler.copy(temp, perm);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Reporter.log("=====" + methodName + "=====FAILED=====", true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("=====" + methodName + "=====SKIPPED=====", true);
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("=====REPORT BACKUP=====", true);
	}

}

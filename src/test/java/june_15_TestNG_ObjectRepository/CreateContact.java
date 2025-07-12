package june_15_TestNG_ObjectRepository;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import genericUtilities.ExcelUtilities;
import objectRepository.ContactPage;
import objectRepository.SelectCampaignPage;
import webDriverUtility.WebDriverUtility;

public class CreateContact extends BaseClass {
	@Test
	public void CreateNewContact() throws Throwable {
		ContactPage con = new ContactPage(driver);
		con.Contacts_Tab();

		ExcelUtilities ExUtil = new ExcelUtilities();
//		JavaUtilities ju = new JavaUtilities();
		WebDriverUtility wu = new WebDriverUtility();
		wu.waitForPageToLoad(driver);
		con.NewContactbtn();
		
		String org = ExUtil.getDataFromExcel("Contacts", 1, 0);
		String title = ExUtil.getDataFromExcel("Contacts", 1, 1);
		String conName = ExUtil.getDataFromExcel("Contacts", 1, 2);
		String mobile = ExUtil.getDataFromExcel("Contacts", 1, 3);
		String email = ExUtil.getDataFromExcel("Contacts", 1, 4);
		String department = ExUtil.getDataFromExcel("Contacts", 1, 5);
		con.CreateContact(org, title, conName, mobile, email, department);
		
		wu.toSwitchToWindow(driver);
		SelectCampaignPage scp = new SelectCampaignPage(driver);
		scp.SelectCampaign();
//		con.SelectCampaign();
		
		wu.toSwitchToParent(driver);
		con.create_contact();
		Thread.sleep(8000);
	}
}

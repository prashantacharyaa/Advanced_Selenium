package june_22_Listeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import genericUtilities.ExcelUtilities;
import genericUtilities.JavaUtilities;
import listenerUtility.ListenerImplementationClass;
import objectRepository.HomePage;
import objectRepository.LeadsPage;
import objectRepository.SelectCampaignPage;
import webDriverUtility.WebDriverUtility;
@Listeners(ListenerImplementationClass.class)
public class CreateLead_Listeners extends BaseClass {
	@Test
	public void CreateNewLead() throws Throwable {
		LeadsPage lp = new LeadsPage(driver);
		HomePage hp = new HomePage(driver);
		hp.LeadsTab();

		ExcelUtilities ExUtil = new ExcelUtilities();
		JavaUtilities ju = new JavaUtilities();
		WebDriverUtility wu = new WebDriverUtility();
		wu.waitForPageToLoad(driver);

		int rno = ju.getRandomNumber();

		String LeadName = ExUtil.getDataFromExcel("Leads", 1, 0);
		LeadName += rno;
		String Company = ExUtil.getDataFromExcel("Leads", 1, 1);
		String LeadSource = ExUtil.getDataFromExcel("Leads", 1, 2);
		String Industry = ExUtil.getDataFromExcel("Leads", 1, 3);
		String Phone = ExUtil.getDataFromExcel("Leads", 1, 4);
		String Email = ExUtil.getDataFromExcel("Leads", 1, 5);
		String LeadStatus = ExUtil.getDataFromExcel("Leads", 1, 6);
		String Rating = ExUtil.getDataFromExcel("Leads", 1, 7);
		String AssignedTo = ExUtil.getDataFromExcel("Leads", 1, 8);
		String City = ExUtil.getDataFromExcel("Leads", 1, 9);

		lp.Create_Lead(LeadName, Company, LeadSource, Industry, Phone, Email, LeadStatus, Rating, AssignedTo, City);
		wu.toSwitchToWindow(driver);
		SelectCampaignPage scp = new SelectCampaignPage(driver);
		scp.SelectCampaign();
//		con.SelectCampaign();

		wu.toSwitchToParent(driver);
		lp.create_Lead();
		Thread.sleep(6000);
	}
}

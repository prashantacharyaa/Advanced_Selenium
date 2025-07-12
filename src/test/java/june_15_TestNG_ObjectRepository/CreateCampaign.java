package june_15_TestNG_ObjectRepository;

import java.io.IOException;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import genericUtilities.ExcelUtilities;
import genericUtilities.JavaUtilities;
import objectRepository.CampaignPage;
import objectRepository.HomePage;

public class CreateCampaign extends BaseClass {
	@Test
	public void CreateCampaign_ORImplementation() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.CreateACampaignBtn();
		Thread.sleep(2000);

		ExcelUtilities ExUtil = new ExcelUtilities();
		JavaUtilities ju = new JavaUtilities();
//			String campId = ExUtil.getDataFromExcel("Sheet1", 1, 0);
		String campName = ExUtil.getDataFromExcel("Sheet1", 1, 1);
		campName += ju.getRandomNumber();
		String campStatus = ExUtil.getDataFromExcel("Sheet1", 1, 2);
		String targetsize = ExUtil.getDataFromExcel("Sheet1", 1, 3);
//		String expectedCloseDate = ExUtil.getDataFromExcel("Sheet1", 1, 4);
//		String targetAudience = ExUtil.getDataFromExcel("sheet1", 1, 5);
//		String description = ExUtil.getDataFromExcel("sheet1", 1, 6);
//	 	String status = ExUtil.getDataFromExcel("Sheet1", 1, 7);

		CampaignPage Cg = new CampaignPage(driver);
		Cg.CreateACampaign(campName, campStatus, targetsize);

	}
}

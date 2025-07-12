package june_08_TestNG_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ToReadDataFromDataProvider {
	@DataProvider
	public Object[][] getStudentDetails() {
		Object[][] objArray = new Object[5][2];
		objArray[0][0] = "Sita";
		objArray[0][1] = "Chicken";
		objArray[1][0] = "Shweta";
		objArray[1][1] = "Paneer Tikka";
		objArray[2][0] = "Sneha";
		objArray[2][1] = "Gulab Jamun";
		objArray[3][0] = "Prashant";
		objArray[3][1] = "Prawns Curry";
		objArray[4][0] = "Umashankar";
		objArray[4][1] = "Mutton Biryani";
		return objArray;
	}

	@Test(dataProvider = "getStudentDetails")
	public void studentDetails(String name, String favFood) {
		System.out.println("Name: " + name + "\t" + "Favourite Food: " + favFood);
	}
}

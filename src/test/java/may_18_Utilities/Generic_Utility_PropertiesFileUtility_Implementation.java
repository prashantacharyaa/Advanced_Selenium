package may_18_Utilities;

import java.io.IOException;

import genericUtilities.PropertyFileUtility;

public class Generic_Utility_PropertiesFileUtility_Implementation {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility pfu = new PropertyFileUtility();
		String browser = pfu.getDataFromPropertiesFile("browser");
		String url = pfu.getDataFromPropertiesFile("url");
		String unm = pfu.getDataFromPropertiesFile("username");
		String pwd = pfu.getDataFromPropertiesFile("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(unm);
		System.out.println(pwd);
	}

}

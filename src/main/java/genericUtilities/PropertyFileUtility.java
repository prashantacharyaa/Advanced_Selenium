package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				"./ConfigData/common.properties");
		// 2. Create object of the properties file
		Properties p = new Properties();
		// 3. Load all the keys
		p.load(fis);
		String data = p.get(key).toString();
		return data;

	}
}

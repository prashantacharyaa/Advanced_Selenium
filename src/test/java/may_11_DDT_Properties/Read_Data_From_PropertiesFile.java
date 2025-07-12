package may_11_DDT_Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Read_Data_From_PropertiesFile {

	public static void main(String[] args) throws IOException {
		// 1. Get the Java representation of the Physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\CRM\\common.properties");
		
		// 2. Create object of the properties file
		Properties p = new Properties();
		
		// 3. Load all the keys
		p.load(fis);
		
		// By taking help of the key read the data
		
		String browser = p.getProperty("browser");
		System.out.println(browser);
		String url = p.getProperty("url");
		System.out.println(url);
		String un = p.getProperty("username");
		System.out.println(un);
		String pw = p.getProperty("password");
		System.out.println(pw);
			
	}

}

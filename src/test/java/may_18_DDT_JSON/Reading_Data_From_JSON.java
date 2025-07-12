package may_18_DDT_JSON;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reading_Data_From_JSON {

	public static void main(String[] args) throws IOException, ParseException {
		// Step 1 : Get access of physical file using file reader
		FileReader fr = new FileReader(
				"C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\Advanced Selenium\\JSONCommonData.json");
		// Parse the JSON Physical file into Java File using JSONParser class.
		JSONParser parser = new JSONParser();

		Object object = parser.parse(fr);
		
		// Convert Java Object to JSONObject using downcasting.
		JSONObject jsonobj = (JSONObject) object;
		
		// Read the data using get() by passing the Key.
		String browser = jsonobj.get("browser").toString();
		System.out.println(browser);
		String url = jsonobj.get("url").toString();
		System.out.println(url);
		String unm  = jsonobj.get("username").toString();
		System.out.println(unm);
		String pwd = jsonobj.get("password").toString();
		System.out.println(pwd);
	}

}

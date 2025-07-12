package may_17_DDT_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Reading_Excel_Data {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step 1: Get the Java Representation object of the Physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\Advanced Selenium\\file_example_XLS_50.xls");
		// Step 2: Open Excel in Read Mode.
		Workbook wb = WorkbookFactory.create(fis);
		// Step 3: Get control of the required sheet
		Sheet sh = wb.getSheet("Sheet1");
		// Step 4: Get the Row control
		Row r = sh.getRow(1);
		// Step 5: Get access to Cell.
		Cell c = r.getCell(0);
		// Step 6: Read the String Value
		String cell1 = c.getStringCellValue();
		System.out.println(cell1);
		wb.close();
	}

}

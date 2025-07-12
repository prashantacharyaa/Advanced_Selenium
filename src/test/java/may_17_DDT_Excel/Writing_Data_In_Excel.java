package may_17_DDT_Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Writing_Data_In_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\Advanced Selenium\\Campaign.xlsx");
		// Step 2: Open Excel in Read Mode.
		Workbook wb = WorkbookFactory.create(fis1);
		// Step 3: Get control of the required sheet
		Sheet sh = wb.getSheet("Sheet1");
		// Step 4: Get the Row control
		Row r = sh.getRow(1);
		// Step 5: Get access to Cell.
		Cell cell = r.createCell(2);
		cell.setCellValue("Pass");

		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\prashanta\\OneDrive - House of Code India Pvt. Ltd\\Desktop\\Advanced Selenium\\Campaign.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
		fis1.close();
	}

}

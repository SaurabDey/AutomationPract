package code.cool.AutomationPract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonUtill {
	WebDriver driver;

	public CommonUtill(WebDriver driver2) {
		driver=driver2;
	}

	public String screenshot(String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\Screens\\"+screenShotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;        
	}

	public List<String> readExcel()
	{
		List<String> data= new ArrayList<>();
		try {
			File file= new File("resource/mydata.xlsx");
			FileInputStream fis= new FileInputStream(file);

			XSSFWorkbook excel= new XSSFWorkbook(fis);
			XSSFSheet sheet= excel.getSheet("Sheet1");
			//----------Read excel---------------//

			String usernameFromExcel= sheet.getRow(1).getCell(0).getStringCellValue();
			String passwordFromExcel= sheet.getRow(1).getCell(1).getStringCellValue();
			String emailIDFromExcel= sheet.getRow(1).getCell(2).getStringCellValue();	
			String daysFromExcel= String.valueOf(sheet.getRow(1).getCell(3).getNumericCellValue());
			String monthsFromExcel= String.valueOf(sheet.getRow(1).getCell(4).getNumericCellValue());


			data.add(usernameFromExcel);
			data.add(passwordFromExcel);
			data.add(emailIDFromExcel);
			data.add(daysFromExcel.split("\\.")[0]);
			data.add(monthsFromExcel.split("\\.")[0]);
			System.out.println(data);
			
			fis.close();
			excel.close();
		} catch (IOException e) {
			System.out.println("Something went wrong in reading excel!!!");
		}
		return data;
	}
}


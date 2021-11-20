package code.cool.AutomationPract;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationClassPOM {

	@FindBy(id="id_gender2")
	WebElement mr;

	@FindBy(id="days")
	WebElement days;

	@FindBy(id="months")
	WebElement months;

	WebDriver driver;
	
	public RegistrationClassPOM(WebDriver driver2) {
		driver=driver2;
		PageFactory.initElements(driver, this);
	}
	public void registration()
	{
		mr.click();

		CommonUtill common= new CommonUtill(driver);
		List<String> exceldata=common.readExcel();
		
		Select daySel= new Select(days);
		daySel.selectByValue(exceldata.get(3));//20-- 20.0

		Select monthsSel= new Select(months);
		monthsSel.selectByValue(exceldata.get(4));//august

	}
}

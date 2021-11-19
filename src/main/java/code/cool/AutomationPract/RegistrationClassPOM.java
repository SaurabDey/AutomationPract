package code.cool.AutomationPract;

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

		Select daySel= new Select(days);
		daySel.selectByValue("20");

		Select monthsSel= new Select(months);
		monthsSel.selectByValue("8");//august

	}
}

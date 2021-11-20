package code.cool.AutomationPract;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClassPOM {

	@FindBy(id="email_create")
	WebElement email;
	
	@FindBy(id="SubmitCreate")
	WebElement createAcct;
	
	WebDriver driver;
	
	public LoginClassPOM(WebDriver driver2) 
	{
		driver=driver2;
		PageFactory.initElements(driver, this);
	}
	
	public void login()
	{	
		System.out.println("Login method");
		
		CommonUtill common= new CommonUtill(driver);
		List<String> exceldata=common.readExcel();
		System.out.println("Excel data at 2 is giving me :::"+ exceldata.get(2));
		email.sendKeys(exceldata.get(2));

		createAcct.click();
	}
}

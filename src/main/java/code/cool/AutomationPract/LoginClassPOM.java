package code.cool.AutomationPract;

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
		email.sendKeys("AdminSaurabTest@gmail.com");

		createAcct.click();
	}
}

package code.cool.AutomationPract;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentRepotWithSelenium {

	WebDriver driver;
	ExtentTest test;
	ExtentReports extent;
	@BeforeTest
	public void setup() throws UnknownHostException
	{
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);
		String myOsName=System.getProperty("os.name");
		extent.setSystemInfo("os", myOsName);

		test= extent.createTest("SeleniumCode");
		String systemName= InetAddress.getLocalHost().getHostName();
		test.assignDevice(systemName);
		test.assignAuthor("Saurab");

		test.info("We are starting the browser!!");
		System.setProperty("webdriver.edge.driver", "resource/msedgedriver.exe");
		driver= new EdgeDriver();
		test.info("Started edge browser!!");
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		test.info("Started automation practice site");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.pass("Setup is complete!!");
	}

	@Test
	public void login() throws IOException
	{
		try {
			test.info("Login method started!!");
			LoginClassPOM log= new LoginClassPOM(driver);
			log.login();
			test.pass("Login methodexecuted successfully!!");
		} catch (Exception e) {
			test.fail("Login had some issue!!"+e.getMessage());
			CommonUtill common= new CommonUtill(driver);
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(common.screenshot("screenshot1")).build());
		}
	}
	@Test
	public void regis() throws IOException
	{
		try {
			test.info("Registration method started!!");
			RegistrationClassPOM reg= new RegistrationClassPOM(driver);
			reg.registration();
			test.pass("Registration methodexecuted successfully!!");
		} catch (Exception e) {
			test.fail("Registration had some issue!!" + e.getMessage());
			CommonUtill common= new CommonUtill(driver);
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(common.screenshot("screenshot2")).build());
		}
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		test.info("Browser is closed!");
		extent.flush();
		test.pass("Extent report generated successfully!!");
	}
	
	
}

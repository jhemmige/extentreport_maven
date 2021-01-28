package jayashreeautomation.ExtentReportsJava;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTest {
	ExtentReports report;
	
	@BeforeTest

	public void reportingConfig() {
		
		
	//to call the method we created and to generate report, we need 2 classes- ExtentSpartReporter and ExtentReports. This class 
		//exposes lots of methods related to extent reports
		
	String path=System.getProperty("user.dir")+"\\reports\\index.html"; // We also need to define a path where this should get saved.
	
	ExtentSparkReporter esr= new ExtentSparkReporter(path);
	
	esr.config().setReportName("WebAutomationReport"); // this is to configure the title of report
	esr.config().setDocumentTitle("My Test Result");// this is to configure the result title.
	
	report = new ExtentReports();//this is the main class. this class needs to have the knowledge of 
	//extentspartreporter which is the helper class, so we pass the obj of the extentsparkreporter as an arg.
	report.attachReporter(esr);
	report.setSystemInfo("User", "Jayashree hemmige");
	
		
	}
	

	@Test

	public void extentreportingDemo() {
	ExtentTest test=	report.createTest("testName LOLO");//we are create a test Name
	
ExtentTest lol=	test.addScreenCaptureFromBase64String("base64", "jay");
System.out.println(lol);
	
	test.addScreenCaptureFromPath("/Users/jayashreehemmige/eclipse-workspace/ExtentReports2Maven\\picture.png");
	

	

		System.setProperty("webdriver.chrome.driver", "/Users/jayashreehemmige/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());

		System.out.println("THis is a test for extent report testing");
		
		report.flush();//this is to end the test and to indicate no more monitoring of the test required.Let's say we need the
		//the report of 5 testcases.Once report is generated for 5 testcases, If flush is added at the end of the test, monitoring will stop
		//This is actually a listener.
	}

}

package base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.CommonUtil;

public class BaseClass {
	protected static WebDriver driver;
	private Properties prop;
	public ExtentReports extent;
	public ExtentHtmlReporter reporter;
	public ExtentTest logger;
	
public BaseClass(){
	prop=new Properties();
	try {
		System.out.println("wiwi");
	
		
			
		FileInputStream fis=new FileInputStream(".\\config\\global.properties");
			prop.load(fis);
			System.out.println("Property File Ready");
	}catch(Exception e) {
			System.out.println(e);
			System.out.println("Property File Not Ready");
	}finally {
			System.out.println("Property File Initiated");
	}
	reporter=new ExtentHtmlReporter(".\\Report\\TestResult.html");
	extent=new ExtentReports();
	extent.attachReporter(reporter);
}

public void init() {
	String bros=prop.getProperty("Browser");
	System.out.println(bros);
	if(bros.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
		driver =new ChromeDriver();
		System.out.println("C_Driver Ready");
		
	}
	else if(bros.equalsIgnoreCase("IE")) {
		System.setProperty("driver.ie.driver", prop.getProperty("iedriverpath"));
		driver=new InternetExplorerDriver();
	}
	driver.get(prop.getProperty("appurl"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(CommonUtil.pageloadtime, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(CommonUtil.impltime, TimeUnit.SECONDS);
}

}

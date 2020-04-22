package testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import utility.CommonUtil;

public class HomePageTest extends BaseClass{
			
	
	
	@BeforeMethod
	public void setup() {
		init();
	}
	//Here we are testing the page Title of Home Page
	@Test
	public void homePagetitletest() {
		
		String acttitle=driver.getTitle();
		Assert.assertTrue(acttitle.contains("The University's international exams group | Cambridge Assessment"));
		boolean x=HomePage.aboutuslink().isDisplayed();
		Assert.assertTrue(x);
		CommonUtil.hover(HomePage.aboutuslink());
		CommonUtil.dwait(5);
		HomePage.ourStrucLink().click();
		CommonUtil.dwait(5);
		String astruc=driver.getTitle();
		Assert.assertTrue(astruc.contains("Our structure"));
		
	}
	
	
	@AfterMethod
	public void trailing() {
		driver.quit();
		
	}

}

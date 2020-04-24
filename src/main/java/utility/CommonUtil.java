package utility;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;
import base.BaseClass;

public class CommonUtil extends BaseClass{
	
	public static final int pageloadtime=10;
	public static final int impltime=20;
	
	public static void hover(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public static void getWindow(int window) {
		List<String> allwin=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allwin.get(window));
	
	}
	public static void dwait(int Seconds) {
		try {
			Thread.sleep(Seconds*1000);
		}catch(Exception e) {
			System.out.println("The error is: "+e);
		}
	}
	
	 public static String capture(String screenShotName)
	    {
		 
	        TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir")+"/ScreenShots/"+screenShotName+System.currentTimeMillis()+".png";
	        File destination = new File(dest);
	        
				try {
					FileUtils.copyFile(source, destination);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}    
			 return dest;
			 
		 }
	    

}

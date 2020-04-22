package utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class HomePage extends BaseClass{
	
	//All the mouse hover element
	public static WebElement aboutuslink() {
		WebElement x=driver.findElement(By.xpath("//*[@class='navigation_list']/li[2]"));
		return x;
	}
	public static WebElement ourStrucLink() {
		WebElement x=driver.findElement(By.xpath("//*[contains(text(),'Our structure')]"));
		return x;
	}
	
	
	
	
	

}

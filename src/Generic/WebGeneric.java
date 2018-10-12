package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class WebGeneric {
	
	public static void waitforVisibilityAndClick(WebDriver driver,long time,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver,time);
		
	try{
		wait.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("Element is Visible",true);
	}
	catch (Exception e) {
		Reporter.log("Element is Not Visible",true);
		Assert.fail();
		
	}
		element.click();
	}
	public static void vrifyURL(WebDriver driver,long time,String partialURL){
		WebDriverWait wait=new WebDriverWait(driver,time);
		
	try{
		wait.until(ExpectedConditions.urlContains(partialURL));
		Reporter.log("Req Page is Displayed",true);
	}
	catch (Exception e) {
		Reporter.log("Req Page is Not Displayed",true);
		Assert.fail();
		
	}
	}


}

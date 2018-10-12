package Generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners(Result.class)
public class BaseTest implements IAutoConstant{
	static{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	public static WebDriver driver;
	
	public String url=TestUtility.getPropertyValue(CONFIG_PATH,"URL");
	public String ITO=TestUtility.getPropertyValue(CONFIG_PATH,"ITO");
	public long lngITOl=Long.parseLong(ITO);
	
	public String ETO=TestUtility.getPropertyValue(CONFIG_PATH,"ETO");
	public long lngETO=Long.parseLong(ETO);

	
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional("localhost")String ip,@Optional("chrome")String browser){
		driver=TestUtility.openBrowser(ip, browser);
		driver.manage().timeouts().implicitlyWait(lngITOl,TimeUnit.SECONDS);
		driver.get(url);
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult result){
		String name=result.getName();
		int status = result.getStatus();
		if(status==2){
			String p = TestUtility.getPhoto(driver,"./photo");
			System.out.println("****************************");
			Reporter.log("TestName:"+name +" Status:FAIL",true);
			System.out.println("****************************");
			Reporter.log("PHOTO:"+p,true);
			System.out.println("****************************");
		}
		else{
			Reporter.log("TestName:"+name +" Status:PASS",true);
		}
		//driver.quit();
	}
}


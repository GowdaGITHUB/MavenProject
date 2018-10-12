package Script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic.TestUtility;

public class ScriptLessUsingPropertyFile {
	static{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	}
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.actitime.com");
		for (int i = 1; i <=4; i++) {
			String k1=TestUtility.getXLData("./input/data.xlsx", "property", i, 0);
			String k2=TestUtility.getXLData("./input/data.xlsx", "property", i, 1);
			String k3=TestUtility.getXLData("./input/data.xlsx", "property", i, 2);

			System.out.println("K1: "+k1);
			System.out.println("K2: "+k2);
			System.out.println("K3: "+k3);

			String xpath=TestUtility.getPropertyValue("./input/elements.properties", k2);

			if (k1.equals("enter")) {
				driver.findElement(By.xpath(xpath)).sendKeys(k3);

			}else if (k1.equals("click")) {
				driver.findElement(By.xpath(xpath)).click();

			}else
			{
				System.out.println("invalid k1");
			}
			Thread.sleep(1000);

		}
		driver.close();

	}

}

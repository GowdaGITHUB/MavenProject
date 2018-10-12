package Script;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


import Generic.BaseTest;
import Generic.Result;
import Generic.TestUtility;
import Generic.WebGeneric;
import Page.DashboardPage;
import Page.LoginPage;

public class DemoA extends BaseTest{
	@Test
	public void testA() throws InterruptedException{
		//Take the input data from excel file
		String uName=TestUtility.getXLData(DATA_PATH, "DemoA",1,0);
		String pWord=TestUtility.getXLData(DATA_PATH, "DemoA",1,1);

		String homePageURL=TestUtility.getXLData(DATA_PATH, "DemoA",1,2);
		String loginPageURL=TestUtility.getXLData(DATA_PATH, "DemoA",1,3);
		//Enter the valid user name,password click login
		LoginPage l=new LoginPage(driver);
		l.setUsername(uName);
		l.setPassword(pWord);
		l.clickLogin();
		//verify that Dashboard Page is Displayed
		WebGeneric.vrifyURL(driver, lngETO, homePageURL);

		//Click Welcome-->logout
		DashboardPage dp=new DashboardPage(driver);
		dp.clickWelcome();
		dp.clickLogout(lngETO);
		//verify that login page is displayed
		WebGeneric.vrifyURL(driver, lngETO, loginPageURL);
	}
}


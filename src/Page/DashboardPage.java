package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Generic.WebGeneric;

public class DashboardPage  {

	private WebDriver driver;

	@FindBy(id="welcome")
	private WebElement welcomeTB;

	@FindBy(xpath="//a[.='Logout']")
	private WebElement logoutBTN;


	public DashboardPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickWelcome(){
		welcomeTB.click();

	}
	public void clickLogout(long time){

		WebGeneric.waitforVisibilityAndClick(driver, 10, logoutBTN);

	}
}